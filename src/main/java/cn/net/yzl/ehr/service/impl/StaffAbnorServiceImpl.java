package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.async.MsgSendAsync;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainInfoDto;
import cn.net.yzl.ehr.fegin.staff.StaffAbnorFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.service.StaffAbnorService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffTrainDto;
import cn.net.yzl.staff.pojo.AbnorRecordPo;
import cn.net.yzl.staff.pojo.RunAbnorRecordPo;
import cn.net.yzl.staff.util.DateStaffUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class StaffAbnorServiceImpl implements StaffAbnorService {

    @Autowired
    private StaffFeginService staffFeginService;

    @Autowired
    private StaffAbnorFeginService staffAbnorFeginService;

    @Autowired
    private MsgSendAsync msgSendAsync;

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
        ComResponse<List<StaffTrainDto>> listComResponse = staffAbnorFeginService.find(staffNo);
       List<StaffTrainInfoDto>list = new ArrayList<>();
        for (StaffTrainDto datum : listComResponse.getData()) {
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
                staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
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
                staffTrainInfoDto.setAdjustLater(datum.getAdjustPostLevelFrontName());
                list.add(staffTrainInfoDto);
            }if (datum.getType()==29){
                StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                staffTrainInfoDto.setType(datum.getType());
                staffTrainInfoDto.setTypeName(datum.getTypeName());
                staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                staffTrainInfoDto.setContent(datum.getContent());
                staffTrainInfoDto.setAdjustFront(String.valueOf(datum.getAdjustSalaryFront()));
                staffTrainInfoDto.setAdjustLater(String.valueOf(datum.getAdjustSalaryLater()));
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
        ComResponse<List<StaffTrainDto>> listComResponse = staffAbnorFeginService.findPage(staffNo,pageNum,pageSize);
        List<StaffTrainInfoDto>list = new ArrayList<>();
        if(listComResponse.getData()!=null){
            for (StaffTrainDto datum : listComResponse.getData()) {
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
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustPostNameLater());
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
                    staffTrainInfoDto.setAdjustLater(datum.getAdjustPostLevelFrontName());
                    list.add(staffTrainInfoDto);
                }if (datum.getType()==29){
                    StaffTrainInfoDto staffTrainInfoDto = new StaffTrainInfoDto();
                    staffTrainInfoDto.setType(datum.getType());
                    staffTrainInfoDto.setTypeName(datum.getTypeName());
                    staffTrainInfoDto.setAbnorTime(datum.getAbnorTime());
                    staffTrainInfoDto.setContent(datum.getContent());
                    staffTrainInfoDto.setAdjustFront(String.valueOf(datum.getAdjustSalaryFront()));
                    staffTrainInfoDto.setAdjustLater(String.valueOf(datum.getAdjustSalaryLater()));
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
    public ComResponse<Page<StaffTrainDto>> findRecordsByPageParam(AbnorRecordPo abnorRecordPo) {
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


    public ComResponse<List<MsgTemplateVo>> timerUpdateAttendFalse(Date date) throws ParseException {
        ComResponse<List<MsgTemplateVo>> listComResponse = staffAbnorFeginService.timerUpdateAttendFalse(date);
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
