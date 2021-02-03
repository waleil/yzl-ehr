package cn.net.yzl.ehr.service.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.parking.ParkingRecoverInsertPo;
import cn.net.yzl.staff.pojo.parking.ParkingVehicleListPo;

public interface ParkingVehicleService {

   //车位占用中列表查询
   ComResponse<Page<ParkingVehicleDto>> selectList(ParkingVehicleListPo parkingVehicleListPo);


   //回收车位
   ComResponse<Integer> insertRecover(ParkingRecoverInsertPo parkingRecoverInsertPo);

   //已清退列表查询
   ComResponse<Page<ParkingRecoverDto>> selectRecoverList(Integer pageNum, Integer pageSize);

   //排队中列表查询
   ComResponse<Page<ParkingApplyDto>> selectApplyList(Integer pageNum, Integer pageSize);

   //插队
   ComResponse<Integer> updateApply(Integer id, Integer sortNo);
}
