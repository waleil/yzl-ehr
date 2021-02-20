package cn.net.yzl.ehr.fegin.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.StaffWorkInsertListPo;
import cn.net.yzl.ehr.pojo.StaffWorkItemPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdateListPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdatePo;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.parking.ParkingRecoverInsertPo;
import cn.net.yzl.staff.pojo.parking.ParkingSetPo;
import cn.net.yzl.staff.pojo.parking.ParkingVehicleListPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

@Repository
@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface ParkingVehicleFeginService {

    @ApiOperation(value = "入司车辆管理-车位占用中列表查询",notes = "入司车辆管理-车位占用中列表查询",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/selectList", method = RequestMethod.POST)
    ComResponse<Page<ParkingVehicleDto>> selectList(@RequestBody ParkingVehicleListPo parkingVehicleListPo);


    @ApiOperation(value = "入司车辆管理-回收车位",notes = "入司车辆管理-回收车位",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/insertRecover", method = RequestMethod.POST)
    ComResponse<Integer> insertRecover(@RequestBody ParkingRecoverInsertPo parkingRecoverInsertPo);

    @ApiOperation(value = "入司车辆管理-已清退列表查询",notes = "入司车辆管理-已清退列表查询",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/selectRecoverList", method = RequestMethod.POST)
    ComResponse<Page<ParkingRecoverDto>> selectRecoverList(@RequestBody ParkingVehicleListPo parkingVehicleListPo);


    @ApiOperation(value = "入司车辆管理-排队中列表查询",notes = "入司车辆管理-排队中列表查询",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/selectApplyList", method = RequestMethod.POST)
    ComResponse<Page<ParkingApplyDto>> selectApplyList(@RequestBody ParkingVehicleListPo parkingVehicleListPo);


    @ApiOperation(value = "入司车辆管理-插队",notes = "入司车辆管理-插队",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/updateApply", method = RequestMethod.POST)
    ComResponse<Integer> updateApply(@RequestParam("id") Integer id,@RequestParam("updator") String updator);


    @ApiOperation(value = "入司车辆管理-车位设置",notes = "入司车辆管理-车位设置",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/insertParkingSet", method = RequestMethod.POST)
    ComResponse<Integer> insertParkingSet(@RequestBody ParkingSetPo parkingSetPo);


    @ApiOperation(value = "入司车辆管理-统计车位",notes = "入司车辆管理-统计车位",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/parking/selectStatisticalList", method = RequestMethod.POST)
    ComResponse  selectStatisticalList();

}
