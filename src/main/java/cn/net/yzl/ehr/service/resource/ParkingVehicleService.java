package cn.net.yzl.ehr.service.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingConfigCountDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.parking.*;

import java.util.List;

public interface ParkingVehicleService {

   //车位占用中列表查询
   ComResponse<Page<ParkingVehicleDto>> selectList(ParkingVehicleListPo parkingVehicleListPo);


   //回收车位
   ComResponse<Integer> insertRecover(ParkingRecoverInsertPo parkingRecoverInsertPo,String staffNo);

   //已清退列表查询
   ComResponse<Page<ParkingRecoverDto>> selectRecoverList(ParkingVehicleListPo parkingVehicleListPo);

   //排队中列表查询
   ComResponse<Page<ParkingApplyDto>> selectApplyList(ParkingVehicleListPo parkingVehicleListPo);

   //插队
   ComResponse<Integer> updateApply(Integer id,String updator);

   //车位设置
    ComResponse<Integer> insertParkingSet(ParkingSetPo parkingSetPo);
   //查询车位
   ComResponse selectStatisticalList();

   //定时扫描
   ComResponse<List<ParkingVehicleUpdatePo>> timerUpdate(String staffNo);
}
