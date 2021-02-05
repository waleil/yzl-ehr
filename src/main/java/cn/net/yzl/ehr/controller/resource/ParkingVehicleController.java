package cn.net.yzl.ehr.controller.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.ehr.service.resource.ParkingVehicleService;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.dto.parking.ParkingApplyDto;
import cn.net.yzl.staff.dto.parking.ParkingRecoverDto;
import cn.net.yzl.staff.dto.parking.ParkingVehicleDto;
import cn.net.yzl.staff.pojo.deduct.DeductItemInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdatePo;
import cn.net.yzl.staff.pojo.parking.ParkingRecoverInsertPo;
import cn.net.yzl.staff.pojo.parking.ParkingSetPo;
import cn.net.yzl.staff.pojo.parking.ParkingVehicleListPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(value = "入司车辆管理", tags = {"公共资源管理"})
public class ParkingVehicleController {
    @Autowired
    private ParkingVehicleService parkingVehicleService;

    @ApiOperation(value = "入司车辆管理-车位占用中列表查询",notes = "入司车辆管理-车位占用中列表查询",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectList", method = RequestMethod.POST)
    ComResponse<Page<ParkingVehicleDto>> selectList(@RequestBody ParkingVehicleListPo parkingVehicleListPo,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
        return parkingVehicleService.selectList(parkingVehicleListPo,pageNum,pageSize);
    }

    @ApiOperation(value = "入司车辆管理-回收车位",notes = "入司车辆管理-回收车位",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertRecover", method = RequestMethod.POST)
    ComResponse<Integer> insertRecover(@RequestBody ParkingRecoverInsertPo parkingRecoverInsertPo) {
        return parkingVehicleService.insertRecover(parkingRecoverInsertPo);
    }

    @ApiOperation(value = "入司车辆管理-已清退列表查询",notes = "入司车辆管理-已清退列表查询",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectRecoverList", method = RequestMethod.POST)
    ComResponse<Page<ParkingRecoverDto>> selectRecoverList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return parkingVehicleService.selectRecoverList(pageNum,pageSize);
    }

    @ApiOperation(value = "入司车辆管理-排队中列表查询",notes = "入司车辆管理-排队中列表查询",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectApplyList", method = RequestMethod.POST)
    ComResponse<Page<ParkingApplyDto>> selectApplyList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return parkingVehicleService.selectApplyList(pageNum,pageSize);
    }

    @ApiOperation(value = "入司车辆管理-插队",notes = "入司车辆管理-插队",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateApply", method = RequestMethod.POST)
    ComResponse<Integer> updateApply(@RequestParam("id") Integer id,@ApiIgnore @CurrentStaffNo String updator) {
        return parkingVehicleService.updateApply(id,updator);
    }

    @ApiOperation(value = "入司车辆管理-车位设置",notes = "入司车辆管理-车位设置",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertParkingSet", method = RequestMethod.POST)
    ComResponse<Integer> insertParkingSet(@RequestBody ParkingSetPo parkingSetPo) {
        return parkingVehicleService.insertParkingSet(parkingSetPo);
    }


    @ApiOperation(value = "入司车辆管理-统计车位",notes = "入司车辆管理-统计车位",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectStatisticalList", method = RequestMethod.POST)
    ComResponse  selectStatisticalList() {
        return parkingVehicleService.selectStatisticalList();
    }

}
