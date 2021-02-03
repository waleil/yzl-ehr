package cn.net.yzl.ehr.service.impl.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.fegin.staff.StaffWorkFeginService;
import cn.net.yzl.ehr.pojo.StaffWorkInsertListPo;
import cn.net.yzl.ehr.pojo.StaffWorkItemPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdateListPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdatePo;
import cn.net.yzl.ehr.service.StaffWorkService;
import cn.net.yzl.ehr.service.resource.ParkingVehicleService;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.parking.ParkingRecoverInsertPo;
import cn.net.yzl.staff.pojo.parking.ParkingVehicleListPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingVehicleServiceImpl implements ParkingVehicleService {


    @Override
    public ComResponse<Page<ParkingVehicleDto>> selectList(ParkingVehicleListPo parkingVehicleListPo) {
        return null;
    }

    @Override
    public ComResponse<Integer> insertRecover(ParkingRecoverInsertPo parkingRecoverInsertPo) {
        return null;
    }

    @Override
    public ComResponse<Page<ParkingRecoverDto>> selectRecoverList(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ComResponse<Page<ParkingApplyDto>> selectApplyList(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ComResponse<Integer> updateApply(Integer id, Integer sortNo) {
        return null;
    }
}
