package cn.net.yzl.ehr.service.impl.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.fegin.resource.ParkingVehicleFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffWorkFeginService;
import cn.net.yzl.ehr.pojo.StaffWorkInsertListPo;
import cn.net.yzl.ehr.pojo.StaffWorkItemPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdateListPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdatePo;
import cn.net.yzl.ehr.service.StaffWorkService;
import cn.net.yzl.ehr.service.resource.ParkingVehicleService;
//import cn.net.yzl.msg.feign.EhrFeignService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingConfigCountDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.parking.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class ParkingVehicleServiceImpl implements ParkingVehicleService {

    @Autowired
    private ParkingVehicleFeginService parkingVehicleFeginService;

    @Autowired
    private YMsgInfoService ymsgInfoService;

    @Autowired
    private StaffFeginService staffFeginService;

    @Override
    public ComResponse<Page<ParkingVehicleDto>> selectList(ParkingVehicleListPo parkingVehicleListPo) {
        return parkingVehicleFeginService.selectList(parkingVehicleListPo);
    }

    @Override
    public ComResponse<Integer> insertRecover(ParkingRecoverInsertPo parkingRecoverInsertPo,String staffNo) {
        parkingRecoverInsertPo.setUpdator(staffNo);
        ComResponse<Integer> response = parkingVehicleFeginService.insertRecover(parkingRecoverInsertPo);
        ComResponse<ParkingVehiclePo> comResponse = parkingVehicleFeginService.queryById(parkingRecoverInsertPo.getId());
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0022");
        templateVo.setCreator(staffNo);
         templateVo.setTitle("车位管理回收车位");
        templateVo.setUserCode(String.valueOf(comResponse.getData()));
        ComResponse<StaffDetailsDto> detailsByNo = staffFeginService.getDetailsByNo(comResponse.getData().getStaffNo());
        String name = detailsByNo.getData().getName();
        Object[] objects = new Object[100];
        objects[0] = name;
        templateVo.setParams(objects);
        templateVo.setSystemCode(2);
        return ymsgInfoService.sendSysMsgInfo(templateVo);
    }

    @Override
    public ComResponse<Page<ParkingRecoverDto>> selectRecoverList(ParkingVehicleListPo parkingVehicleListPo) {
        return parkingVehicleFeginService.selectRecoverList(parkingVehicleListPo);
    }

    @Override
    public ComResponse<Page<ParkingApplyDto>> selectApplyList(ParkingVehicleListPo parkingVehicleListPo) {
        return parkingVehicleFeginService.selectApplyList(parkingVehicleListPo);
    }

    @Override
    public ComResponse<Integer> updateApply(Integer id,String updator) {
        return parkingVehicleFeginService.updateApply(id,updator);
    }

    @Override
    public ComResponse<Integer> insertParkingSet(ParkingSetPo parkingSetPo) {
        return parkingVehicleFeginService.insertParkingSet(parkingSetPo);
    }

    @Override
    public ComResponse<ParkingConfigCountDto> selectStatisticalList() {
        return parkingVehicleFeginService.selectStatisticalList();
    }

    @Override
    public ComResponse<List<ParkingVehicleUpdatePo>> timerUpdate(String staffNo) {
        ComResponse<List<ParkingVehicleUpdatePo>> list = parkingVehicleFeginService.timerUpdate();
            if(!CollectionUtils.isEmpty(list.getData())){
                for (ParkingVehicleUpdatePo datum : list.getData()) {
                    ComResponse<ParkingVehiclePo> comResponse = parkingVehicleFeginService.queryById(list.getData().size());
                    MsgTemplateVo templateVo = new MsgTemplateVo();
                    templateVo.setCode("EHR0016");
                    templateVo.setCreator(staffNo);
                    templateVo.setTitle("车位管理排队进入停放");
                    templateVo.setUserCode(datum.getStaffNo());
                    String name = staffFeginService.getDetailsByNo(datum.getStaffNo()).getData().getName();
                    Object[] objects = new Object[100];
                    objects[0] = name;
                    templateVo.setParams(objects);
                    templateVo.setSystemCode(2);
                    ymsgInfoService.sendSysMsgInfo(templateVo);
                }
            }
        return  list;
    }
}
