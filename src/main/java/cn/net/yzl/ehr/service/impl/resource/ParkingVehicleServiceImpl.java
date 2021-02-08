package cn.net.yzl.ehr.service.impl.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.fegin.resource.ParkingVehicleFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffWorkFeginService;
import cn.net.yzl.ehr.pojo.StaffWorkInsertListPo;
import cn.net.yzl.ehr.pojo.StaffWorkItemPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdateListPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdatePo;
import cn.net.yzl.ehr.service.StaffWorkService;
import cn.net.yzl.ehr.service.resource.ParkingVehicleService;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingConfigCountDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.parking.ParkingRecoverInsertPo;
import cn.net.yzl.staff.pojo.parking.ParkingSetPo;
import cn.net.yzl.staff.pojo.parking.ParkingVehicleListPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParkingVehicleServiceImpl implements ParkingVehicleService {

    @Autowired
    private ParkingVehicleFeginService parkingVehicleFeginService;
    @Override
    public ComResponse<Page<ParkingVehicleDto>> selectList(ParkingVehicleListPo parkingVehicleListPo) {
        return parkingVehicleFeginService.selectList(parkingVehicleListPo);
    }

    @Override
    public ComResponse<Integer> insertRecover(ParkingRecoverInsertPo parkingRecoverInsertPo,String staffNo) {
        parkingRecoverInsertPo.setUpdator(staffNo);
        parkingRecoverInsertPo.setUpdateTime(new Date());
        return parkingVehicleFeginService.insertRecover(parkingRecoverInsertPo);
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
}
