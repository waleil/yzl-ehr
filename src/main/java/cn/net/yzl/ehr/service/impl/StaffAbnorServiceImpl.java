package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.async.MsgSendAsync;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainInfoDto;
import cn.net.yzl.ehr.fegin.staff.StaffAbnorFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordSalaryPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.service.StaffAbnorService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.pm.model.dto.MenuDTO;
import cn.net.yzl.pm.service.RoleMenuService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffTrainDto;
import cn.net.yzl.staff.pojo.AbnorRecordPo;
import cn.net.yzl.staff.pojo.RunAbnorRecordPo;
import cn.net.yzl.staff.util.DateStaffUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class StaffAbnorServiceImpl implements StaffAbnorService {

    @Autowired
    private StaffFeginService staffFeginService;

    @Autowired
    private StaffAbnorFeginService staffAbnorFeginService;

    @Autowired
    private MsgSendAsync msgSendAsync;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public ComResponse<Integer> updateStaffChangeStatus(StaffSwitchStatePo staffSwitchStatePo,String staffNo) {
        staffSwitchStatePo.setUpdator(staffNo);
        ComResponse<Integer> comResponse = staffAbnorFeginService.updateStaffChangeStatus(staffSwitchStatePo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> executeStaffChange(StaffAbnorRecordPo staffChangePo,String staffNo) throws ParseException {
        staffChangePo.setCreator(staffNo);
        ComResponse<StaffDetailsDto> detailsByNo = staffFeginService.getDetailsByNo(staffChangePo.getStaffNo());
        if(detailsByNo==null){
         return   ComResponse.fail(ResponseCodeEnums.STAFF_NOT_EXIT_CODE.getCode(),ResponseCodeEnums.STAFF_NOT_EXIT_CODE.getMessage());
        }
        try{
        msgSendAsync.addStaffAbnorNotice(staffNo,staffChangePo.getStaffNo(),detailsByNo.getData().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        ComResponse<Integer> comResponse = staffAbnorFeginService.executeStaffChange(staffChangePo);
        if(comResponse==null){
         return   ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            //如果异动时间小于等于现在，则已执行，发送异动执行消息
            if(DateStaffUtils.stringToDate(staffChangePo.getAbnorTime(),"yyyy-MM-dd","yyyy-MM-dd").getTime()<=new Date().getTime()){
                try{
                    msgSendAsync.executeStaffAbnorNotice(staffNo,staffChangePo.getStaffNo(),detailsByNo.getData().getName());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
         return   ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<StaffAbnorRecordListDto> getStaffAbnorRecord(String staffNo) {
        ComResponse<StaffAbnorRecordListDto> comResponse = staffAbnorFeginService.getStaffAbnorRecord(staffNo);
        if(comResponse==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return comResponse;
    }

    @Override
    public ComResponse<List<StaffTrainInfoDto>> find(String staffNo) {
       DecimalFormat df=new DecimalFormat("0.00");
        StringBuffer front=new StringBuffer("");
        StringBuffer later=new StringBuffer("");
       ComResponse<List<StaffTrainDto>> listComResponse = staffAbnorFeginService.find(staffNo);
       List<StaffTrainInfoDto>list = new ArrayList<>();
        for (StaffTrainDto datum : listComResponse.getData()) {
            if(datum.getType()==25){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getCourseName());
                list.add(staffTrainInfoDto);
            }
            if(datum.getType()==26){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());
                staffTrainInfoDto.setAdjustFront(datum.getAdjustPostNameFront()+"("+datum.getAdjustDepartNameFront()+")");
                staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater()+"("+datum.getAdjustDepartNameLater()+")");
                list.add(staffTrainInfoDto);
            }if (datum.getType()==23|| datum.getType()==30||datum.getType()==31||datum.getType()==68){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());
                staffTrainInfoDto.setAdjustFront(datum.getAdjustDepartNameFront());
                staffTrainInfoDto.setAdjustLater("-");
                list.add(staffTrainInfoDto);
            }if (datum.getType()==24 || datum.getType()==69){ //入职||入岗
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());
                //  页面显示为调整前后，数据无调整前，将调整后部门的值赋给调整前
                staffTrainInfoDto.setAdjustFront(datum.getAdjustDepartNameLater());
                staffTrainInfoDto.setAdjustLater(datum.getAdjustDepartNameLater());
                list.add(staffTrainInfoDto);
            }if (datum.getType()==27){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());
                //  页面显示为调整前后，数据无调整前，将调整后岗位的值赋给调整前
                staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
                staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
                list.add(staffTrainInfoDto);
            }if (datum.getType()==72 || datum.getType()== 73){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());
                staffTrainInfoDto.setAdjustFront(datum.getAdjustPostLevelFrontName());
                staffTrainInfoDto.setAdjustLater(datum.getAdjustPostLevelLaterName());
                list.add(staffTrainInfoDto);
            }if (datum.getType()==29){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());

                if(datum.getAdjustSalaryFrontD()!=null ){
                    front.append("调整前岗位薪酬："+datum.getAdjustSalaryFrontD()+"元;");
                }
                if(datum.getAdjustSalaryLaterD()!=null){
                    later.append("调整后岗位薪酬："+datum.getAdjustSalaryLaterD()+"元;");
                }
                if(datum.getAdjustFullAttendanceSalaryFrontD()!=null){
                    front.append("调整前全勤工资："+datum.getAdjustFullAttendanceSalaryFrontD()+"元;");
                }
                if(datum.getAdjustFullAttendanceSalaryLaterD()!=null){
                    later.append("调整后全勤工资："+datum.getAdjustFullAttendanceSalaryLaterD()+"元;");
                }
                if(datum.getAdjustPerformanceSalaryFrontD()!=null){
                    front.append("调整前绩效工资："+datum.getAdjustPerformanceSalaryFrontD()+"元;");
                }
                if(datum.getAdjustPerformanceSalaryLaterD()!=null){
                    later.append("调整后绩效工资："+datum.getAdjustPerformanceSalaryLaterD()+"元;");
                }
                if(datum.getAdjustWageSalaryFrontD()!=null){
                    front.append("调整前岗位工资："+datum.getAdjustWageSalaryFrontD()+"元;");
                }
                if(datum.getAdjustWageSalaryLaterD()!=null){
                    later.append("调整后岗位工资："+datum.getAdjustWageSalaryLaterD()+"元;");
                }
                if(datum.getAdjustBasicSalaryFrontD()!=null){
                    front.append("调整前基本工资："+datum.getAdjustBasicSalaryFrontD()+"元;");
                }
                if(datum.getAdjustBasicSalaryLaterD()!=null){
                    later.append("调整后基本工资："+datum.getAdjustBasicSalaryLaterD()+"元;");
                }
//                if(datum.getAdjustBasicSalaryTypeFront()!=null){
//                    front.append("调整前基本工资类型："+ (datum.getAdjustBasicSalaryTypeFront()==1?"日薪":"月薪")+";");
//                }
//                if(datum.getAdjustBasicSalaryTypeLater()!=null){
//                    later.append("调整后基本工资类型："+ (datum.getAdjustBasicSalaryTypeLater()==1?"日薪":"月薪")+";");
//                }

                staffTrainInfoDto.setAdjustFront(String.valueOf(front));
                staffTrainInfoDto.setAdjustLater(String.valueOf(later));
                list.add(staffTrainInfoDto);
            }
        }
        if (list==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success(list);
    }

    @Override
    public ComResponse<List<StaffTrainInfoDto>> findPage(String staffNo, Integer pageNum, Integer pageSize) {
        DecimalFormat df=new DecimalFormat("0.00");
        StringBuffer front=new StringBuffer("");
        StringBuffer later=new StringBuffer("");
        ComResponse<List<StaffTrainDto>> listComResponse = staffAbnorFeginService.findPage(staffNo,pageNum,pageSize);
        List<StaffTrainInfoDto>list = new ArrayList<>();
        if(listComResponse.getData()!=null){
            for (StaffTrainDto datum : listComResponse.getData()) {
                if(datum.getType()==25){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getCourseName());
                    list.add(staffTrainInfoDto);
                }
                if(datum.getType()==26){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    staffTrainInfoDto.setAdjustFront(datum.getAdjustPostNameFront());
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
                    list.add(staffTrainInfoDto);
                }if (datum.getType()==23|| datum.getType()==30||datum.getType()==31||datum.getType()==68){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    staffTrainInfoDto.setAdjustFront(datum.getAdjustDepartNameFront());
                    staffTrainInfoDto.setAdjustLater("");
                    list.add(staffTrainInfoDto);
                }if (datum.getType()==24 || datum.getType()==69){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustDepartNameLater());
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
                    list.add(staffTrainInfoDto);
                }if (datum.getType()==27){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustDepartNameLater());
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
                    list.add(staffTrainInfoDto);
                }if (datum.getType()==72 || datum.getType()== 73){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    staffTrainInfoDto.setAdjustFront(datum.getAdjustPostLevelFrontName());
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustPostLevelLaterName());
                    list.add(staffTrainInfoDto);
                }if (datum.getType()==29){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    if(datum.getAdjustSalaryFrontD()!=null ){
                        front.append("调整前岗位薪酬："+datum.getAdjustSalaryFrontD()+"元;");
                    }
                    if(datum.getAdjustSalaryLaterD()!=null){
                        later.append("调整后岗位薪酬："+datum.getAdjustSalaryLaterD()+"元;");
                    }
                    if(datum.getAdjustFullAttendanceSalaryFrontD()!=null){
                        front.append("调整前全勤工资："+datum.getAdjustFullAttendanceSalaryFrontD()+"元;");
                    }
                    if(datum.getAdjustFullAttendanceSalaryLaterD()!=null){
                        later.append("调整后全勤工资："+datum.getAdjustFullAttendanceSalaryLaterD()+"元;");
                    }
                    if(datum.getAdjustPerformanceSalaryFrontD()!=null){
                        front.append("调整前绩效工资："+datum.getAdjustPerformanceSalaryFrontD()+"元;");
                    }
                    if(datum.getAdjustPerformanceSalaryLaterD()!=null){
                        later.append("调整后绩效工资："+datum.getAdjustPerformanceSalaryLaterD()+"元;");
                    }
                    if(datum.getAdjustWageSalaryFrontD()!=null){
                        front.append("调整前岗位工资："+datum.getAdjustWageSalaryFrontD()+"元;");
                    }
                    if(datum.getAdjustWageSalaryLaterD()!=null){
                        later.append("调整后岗位工资："+datum.getAdjustWageSalaryLaterD()+"元;");
                    }
                    if(datum.getAdjustBasicSalaryFrontD()!=null){
                        front.append("调整前基本工资："+datum.getAdjustBasicSalaryFrontD()+"元;");
                    }
                    if(datum.getAdjustBasicSalaryLaterD()!=null){
                        later.append("调整后基本工资："+datum.getAdjustBasicSalaryLaterD()+"元;");
                    }
//                    if(datum.getAdjustBasicSalaryTypeFront()!=null){
//                        front.append("调整前基本工资类型："+ (datum.getAdjustBasicSalaryTypeFront()==1?"日薪":"月薪")+";");
//                    }
//                    if(datum.getAdjustBasicSalaryTypeLater()!=null){
//                        later.append("调整后基本工资类型："+ (datum.getAdjustBasicSalaryTypeLater()==1?"日薪":"月薪")+";");
//                    }

                    staffTrainInfoDto.setAdjustFront(String.valueOf(front));
                    staffTrainInfoDto.setAdjustLater(String.valueOf(later));
                    list.add(staffTrainInfoDto);
                }
            }
        }
        if (list.size()==0){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }else {
            return ComResponse.success(list);
        }
    }

    @Override
    public ComResponse<Page<StaffTrainDto>> findRecordsByPageParam(AbnorRecordPo abnorRecordPo, HttpServletRequest request) {

        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        log.info(JsonUtil.toJsonStr(menuDTO));
//        menuDTO.getMenuName();//获取菜单名称
//        menuDTO.getIsAdmin();//获取最高权限标识
        //最高权限标识
        if(menuDTO!=null && menuDTO.getIsAdmin()!=null && menuDTO.getIsAdmin()==1 ){
            //全量，只根据departId查询
            abnorRecordPo.setStaffNo(null);
        }else{
            //会增加部门负责人限制
            abnorRecordPo.setStaffNo(userNo);
        }
        ComResponse<Page<StaffTrainDto>> recordsByPageParam = staffAbnorFeginService.findRecordsByPageParam(abnorRecordPo);
        if (recordsByPageParam==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (recordsByPageParam.getData()!=null && recordsByPageParam.getCode() == 200){
            ComResponse.success();
        }
        return recordsByPageParam;
    }


    @Override
    public ComResponse<Integer> runStaffChange(RunAbnorRecordPo staffChangePo,String staffNo) throws ParseException {
        staffChangePo.setCreator(staffNo);
        ComResponse<Integer> integerComResponse = staffAbnorFeginService.runStaffChange(staffChangePo);
        if (integerComResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return integerComResponse;
    }


    public ComResponse<List<MsgTemplateVo>> timerUpdateStafffAbnorRecord() throws ParseException {
        ComResponse<List<MsgTemplateVo>> listComResponse = staffAbnorFeginService.timerUpdateStafffAbnorRecord();
        if(listComResponse!=null && listComResponse.getData()!=null && !listComResponse.getData().isEmpty()){
            List<MsgTemplateVo> msgTemplateVoList = listComResponse.getData();
            msgTemplateVoList.forEach(x->{
                try {
                    msgSendAsync.sendMsg(x);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        return listComResponse;
    }

    @Override
    public ComResponse<List<MsgTemplateVo>> staffBatchPostLevelTimedTask() throws ParseException {
        ComResponse<List<MsgTemplateVo>> listComResponse = staffAbnorFeginService.staffBatchPostLevelTimedTask();
        if(listComResponse!=null && listComResponse.getData()!=null && !listComResponse.getData().isEmpty()){
            List<MsgTemplateVo> msgTemplateVoList = listComResponse.getData();
            msgTemplateVoList.forEach(x->{
                try {
                    msgSendAsync.sendMsg(x);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        return listComResponse;
    }

    @Override
    public ComResponse<List<MsgTemplateVo>> staffBatchPostLevelTimedDayTask() throws ParseException {
        ComResponse<List<MsgTemplateVo>> listComResponse = staffAbnorFeginService.staffBatchPostLevelTimedDayTask();
        if(listComResponse!=null && listComResponse.getData()!=null && !listComResponse.getData().isEmpty()){
            List<MsgTemplateVo> msgTemplateVoList = listComResponse.getData();
            msgTemplateVoList.forEach(x->{
                try {
                    msgSendAsync.sendMsg(x);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        return listComResponse;
    }


}
