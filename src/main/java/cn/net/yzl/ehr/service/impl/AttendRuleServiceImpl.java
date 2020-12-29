package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.AttendRushClassDto;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.fegin.conf.AttendRuleFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.fegin.post.PostFeginMapper;
import cn.net.yzl.ehr.service.AttendRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AttendRuleServiceImpl implements AttendRuleService {
    @Autowired
    private AttendRuleFeginService attendRuleFeginService;
    @Autowired
    private DepartFeginService departFeginService;
    @Autowired
    private PostFeginMapper postFeginMapper;


    @Override
    public ComResponse<Integer> update(DepartAttendRuleDto departAttendRuleDto) {


        return attendRuleFeginService.update(departAttendRuleDto);
    }

    @Override
    public ComResponse<Integer> addOrUpdate(List<DepartAttendRuleDto> departAttendRuleDto, String staffNo) {

        ComResponse<Integer> result = checkParam(departAttendRuleDto, staffNo);
        if (result.getCode() != 200) {
            return result;
        }
        return attendRuleFeginService.addOrUpdate(departAttendRuleDto);
    }


    private ComResponse<Integer> checkParam(List<DepartAttendRuleDto> departAttendRuleDto, String staffNo) {
        Integer type = departAttendRuleDto.get(0).getType();
        String repx = "^(0[1-9]|1[012]):(0[1-9]|[12][0-9]|3[01])$";

        if (type == 32 || type == 35) {   // 定时打卡-正常 指向字典表
            for (DepartAttendRuleDto attendRuleDto : departAttendRuleDto) {
                Date time = attendRuleDto.getTime();
                // 对时间判断
                int compare = DateUtil.compare(time, new Date());
                if (compare == 0 || compare < 0) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "查询时间 time : {},不编辑本月以前的规则!" + time);
                }
                Integer departId = attendRuleDto.getDepartId();
                String format = DateUtil.format(time, "yyyy-MM");
                Integer postId = attendRuleDto.getPostId();
                ComResponse<DepartAttendRuleDto> byParams = attendRuleFeginService.getByParams(departId, format, postId, null);
                if (byParams.getData() != null) {
                    attendRuleDto.setFlag(2);
                } else {
                    attendRuleDto.setFlag(1);
                }

                int flag = attendRuleDto.getFlag();
                if (flag == 1) {  // 创建
                    ComResponse<DepartDto> byId = departFeginService.getById(departId);
                    if (byId.getData() == null) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "departId : {} 参数错误!", departId);
                    }
                    ComResponse<PostDto> postById = postFeginMapper.getPostById(postId);
                    if (postById.getData() == null) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "postId : {} 参数异常!", postId);
                    }
                    attendRuleDto.setCreator(staffNo);
                } else {
                    Integer id = attendRuleDto.getId();
                    if (id == null || id < 1) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "规则 id: {} 必传!" + id);
                    }
                    attendRuleDto.setUpdator(staffNo);
                    attendRuleDto.setDepartId(null);
                    attendRuleDto.setPostId(null);
                }

                if(type==32){

                    // 上班时段的判断:
                    String workStartTime = attendRuleDto.getWorkStartTime();
                    if (StrUtil.isBlank(workStartTime) && !ReUtil.isMatch(repx, workStartTime)) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "workStartTime(考勤时段:上班时间): {} 参数错误!" + workStartTime);
                    }
                    String workEndTime = attendRuleDto.getWorkEndTime();
                    if (StrUtil.isBlank(workEndTime) && !ReUtil.isMatch(repx, workEndTime)) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "workEndTime(考勤时段:下班时间): {} 参数错误!" + workEndTime);
                    }
                }
                String restStartTime = attendRuleDto.getRestStartTime();
                if (StrUtil.isBlank(restStartTime) && !ReUtil.isMatch(repx, restStartTime)) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "restStartTime(中休时段:中休开始时间): {} 参数错误!" + restStartTime);
                }
                String restEndTime = attendRuleDto.getRestEndTime();
                if (StrUtil.isBlank(restEndTime) && !ReUtil.isMatch(repx, restEndTime)) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "restEndTime(中休时段:中休结束时间): {} 参数错误!" + restEndTime);
                }
                Integer lateTime = attendRuleDto.getLateTime();
                if (lateTime < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "lateTime(迟到规则): {} 参数错误!" + lateTime);
                }
                Integer leaveTime = attendRuleDto.getLeaveTime();
                if (leaveTime < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "leaveTime(早退规则): {} 参数错误!" + leaveTime);
                }
                Integer weekFlag = attendRuleDto.getWeekFlag();
                if (weekFlag != 1 && weekFlag != 0) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "weekFlag(是否大小周): {} 参数错误!" + weekFlag);
                }
                if (weekFlag == 1) {
                    String weekBitStr = attendRuleDto.getWeekBitStr();
                    try {
                        int weekBit = NumberUtil.binaryToInt(weekBitStr);
                        attendRuleDto.setWeekBit(weekBit);

                    } catch (Exception e) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "weekBitStr(是否二进制): {} 参数错误!" + weekBitStr);
                    }
                }

                if(type == 35){
                    String elasticUpStartTime = attendRuleDto.getElasticUpStartTime();
                    if (StrUtil.isBlank(elasticUpStartTime) && !ReUtil.isMatch(repx, elasticUpStartTime)) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "elasticUpStartTime(弹性上班:中休开始时间): {} 参数错误!" + elasticUpStartTime);
                    }

                    String elasticUpEndTime = attendRuleDto.getElasticUpEndTime();
                    if (StrUtil.isBlank(elasticUpEndTime) && !ReUtil.isMatch(repx, elasticUpEndTime)) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "elasticUpEndTime(中休时段:中休开始时间): {} 参数错误!" + elasticUpEndTime);
                    }

                    String elasticDownStartTime = attendRuleDto.getElasticDownStartTime();
                    if (StrUtil.isBlank(elasticDownStartTime) && !ReUtil.isMatch(repx, elasticDownStartTime)) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "elasticDownStartTime(中休时段:中休开始时间): {} 参数错误!" + elasticDownStartTime);
                    }
                    String elasticDownEndTime = attendRuleDto.getElasticDownEndTime();

                    if (StrUtil.isBlank(elasticDownEndTime) && !ReUtil.isMatch(repx, elasticDownEndTime)) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "elasticDownEndTime(中休时段:中休开始时间): {} 参数错误!" + elasticDownEndTime);
                    }

                }
            }
            return ComResponse.success(1);
        } else if (type == 33) {  // 定时打卡-可抢
            for (DepartAttendRuleDto attendRuleDto : departAttendRuleDto) {
                Date time = attendRuleDto.getTime();
                // 对时间判断
                int compare = DateUtil.compare(time, new Date());
                if (compare == 0 || compare < 0) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "查询时间 time : {},不编辑本月以前的规则!" + time);
                }

                Integer departId = attendRuleDto.getDepartId();
                String format = DateUtil.format(time, "yyyy-MM");
                Integer postId = attendRuleDto.getPostId();
                ComResponse<DepartAttendRuleDto> byParams = attendRuleFeginService.getByParams(departId, format, postId, null);
                if (byParams.getData() != null) {
                    attendRuleDto.setFlag(2);
                } else {
                    attendRuleDto.setFlag(1);
                }
                int flag = attendRuleDto.getFlag();
                if (flag == 1) {  // 创建
                    ComResponse<DepartDto> byId = departFeginService.getById(departId);
                    if (byId.getData() == null) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "departId : {} 参数错误!", departId);
                    }
                    ComResponse<PostDto> postById = postFeginMapper.getPostById(postId);
                    if (postById.getData() == null) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "postId : {} 参数异常!", postId);
                    }
                    attendRuleDto.setCreator(staffNo);
                } else {
                    Integer id = attendRuleDto.getId();
                    if (id == null || id < 1) {
                        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "规则 id: {} 必传!" + id);
                    }
                    attendRuleDto.setUpdator(staffNo);
                    attendRuleDto.setDepartId(null);
                    attendRuleDto.setPostId(null);
                }

                // 上班时段的判断:
                String workStartTime = attendRuleDto.getWorkStartTime();

                if (StrUtil.isBlank(workStartTime) && !ReUtil.isMatch(repx, workStartTime)) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "workStartTime(考勤时段:上班时间): {} 参数错误!" + workStartTime);
                }
                String workEndTime = attendRuleDto.getWorkEndTime();
                if (StrUtil.isBlank(workEndTime) && !ReUtil.isMatch(repx, workEndTime)) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "workEndTime(考勤时段:下班时间): {} 参数错误!" + workEndTime);
                }
                String restStartTime = attendRuleDto.getRestStartTime();
                if (StrUtil.isBlank(restStartTime) && !ReUtil.isMatch(repx, restStartTime)) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "restStartTime(中休时段:中休开始时间): {} 参数错误!" + restStartTime);
                }
                String restEndTime = attendRuleDto.getRestEndTime();
                if (StrUtil.isBlank(restEndTime) && !ReUtil.isMatch(repx, restEndTime)) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "restEndTime(中休时段:中休结束时间): {} 参数错误!" + restEndTime);
                }
                Integer lateTime = attendRuleDto.getLateTime();
                if (lateTime < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "lateTime(迟到规则): {} 参数错误!" + lateTime);
                }
                Integer leaveTime = attendRuleDto.getLeaveTime();
                if (leaveTime < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "leaveTime(早退规则): {} 参数错误!" + leaveTime);
                }
                Double rushAbsenRate = attendRuleDto.getRushAbsenRate();
                if (leaveTime < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "rushAbsenRate(抢休规则(每天缺勤率,小于)): {} 参数错误!" + rushAbsenRate);
                }
                Double rushDays = attendRuleDto.getRushDays();
                if (rushDays < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "rushDays(抢休规则(每人每天抢休天数,小于等于)): {} 参数错误!" + rushDays);
                }
                Integer rushStart = attendRuleDto.getRushStart();
                if (rushStart < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "rushStart(抢休开始时间(几号)): {} 参数错误!" + rushStart);
                }
                Integer rushEnd = attendRuleDto.getRushEnd();
                if (rushEnd < 1) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "rushEnd(抢休结束时间(几号)): {} 参数错误!" + rushEnd);
                }

                String crycleStr = attendRuleDto.getCrycleStr();
                try {
                    int crycle = NumberUtil.binaryToInt(crycleStr);
                    attendRuleDto.setCrycle(crycle);
                } catch (Exception e) {
                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "crycleStr(字符创 01010101  1表示勾选,0表示不勾选): {} 参数错误!" + crycleStr);

                }
                Integer halfFlag = attendRuleDto.getHalfFlag();
                if (halfFlag == 1) {
                    List<AttendRushClassDto> attendRushClassDtoList = attendRuleDto.getAttendRushClassDtoList();
                    if (attendRushClassDtoList != null && attendRushClassDtoList.size() > 0) {
                        for (AttendRushClassDto attendRushClassDto : attendRuleDto.getAttendRushClassDtoList()) {
                            int flag1 = attendRuleDto.getFlag();
                            if (flag1 == 1) {
                                attendRushClassDto.setCreator(staffNo);
                            } else {
                                Integer id = attendRuleDto.getId();
                                if (id==null || id < 1) {
                                    return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "attendClassId ; {} 参数错误!" + id);
                                }
                            }
                            String startTime = attendRushClassDto.getStartTime();
                            String endTime = attendRushClassDto.getEndTime();
                            String name = attendRushClassDto.getName();


                            if (StrUtil.isBlank(startTime) && !ReUtil.isMatch(repx, workEndTime)) {
                                return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "考勤班次  startTime: {}" + startTime);
                            }
                            if (StrUtil.isBlank(endTime) && !ReUtil.isMatch(repx, endTime)) {
                                return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "考勤班次  endTime: {}" + endTime);
                            }

                            if (StrUtil.isBlank(name)) {
                                return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "考勤班次  name: {}" + name);
                            }
                        }
                    }
                }
            }
            return ComResponse.success(1);
        }
//        else if(type==34){  // 弹性打卡
//            return ComResponse.success(1);
//        }
        else if (type == 35) {  // 不打卡
            return ComResponse.success(1);
        } else {

            return ComResponse.success(0);
        }
    }

    @Override
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartIdAndTime(Integer departId, Integer pageNo, Integer pageSize, String time) {
        ComResponse<Page<DepartAttendRuleDto>> byDepartIdAndTime = attendRuleFeginService.getByDepartIdAndTime(departId, pageNo, pageSize, time);

        if (byDepartIdAndTime.getData().getItems() == null || byDepartIdAndTime.getData().getItems().size() < 1) {
            return ComResponse.nodata();
        }
        return byDepartIdAndTime;
    }

    @Override
    public ComResponse<DepartAttendRuleDto> getByParams(Integer departId, String time, Integer postId, Integer typeId) {

        ComResponse<DepartAttendRuleDto> result = attendRuleFeginService.getByParams(departId, time, postId, typeId);

        if (result.getData() == null) {
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<List<PostDto>> getPostList(Integer departId) {

        ComResponse<List<PostDto>> result = attendRuleFeginService.getPostList(departId);

        if (result.getData() == null && result.getData().size() < 0) {
            return ComResponse.nodata();
        }

        return result;
    }


    public static void main(String[] args) {
        String repx = "^(0[1-9]|1[012]):(0[1-9]|[12][0-9]|3[01])$";
        System.err.println(ReUtil.isMatch(repx, "23:12"));
    }
}
