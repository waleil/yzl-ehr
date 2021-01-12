package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffUpRpListDto;
import cn.net.yzl.ehr.dto.StaffUpTrainListDto;
import cn.net.yzl.ehr.pojo.*;

import cn.net.yzl.ehr.service.StaffGrowUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/staffGrowUp")
@Api(value = "员工成长信息", tags = {"员工成长信息"})
@Valid
public class StaffGrowUpController {
    @Autowired
    private StaffGrowUpService staffGrowUpService;

    @ApiOperation(value = "查询员工成长中奖惩信息",notes = "查询员工成长中奖惩信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffUpRpListDto> findByStaffNo(@RequestParam("staffNO")String staffNO) {
        return staffGrowUpService.findByStaffNo(staffNO);
    }
/*
    @ApiOperation(value = "删除员工成长中奖惩信息",notes = "删除员工成长中奖惩信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@Min(1) @NotNull Integer id, @ApiIgnore @CurrentStaffNo String updator) {
        return staffGrowUpService.deleteById(id,updator);
    }

    @ApiOperation(value = "添加员工成长中奖惩信息", notes = "添加员工成长中奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工编号", required = true, paramType = "query")
    )
    ComResponse<Integer> insert(@RequestBody @Validated List<StaffUpRpInsertPo> staff) {
        return staffGrowUpService.insert(staff);
    }

    @ApiOperation(value = "修改员工成长中奖惩信息", notes = "修改员工成长中奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody @Validated StaffUpRpUpdatePo FamilyPo){
        return staffGrowUpService.update(FamilyPo);
    }*/

    @ApiOperation(value = "保存员工成长中奖惩信息", notes = "保存员工成长中奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody @Validated StaffUpRpItemPo itemPo,@ApiIgnore @CurrentStaffNo String updator){
        itemPo.getInsertList().forEach(x->{
            x.setCreator(updator);
        });
        itemPo.getUpdateList().forEach(x->{
            x.setUpdator(updator);
        });
        itemPo.getDeleteList().forEach(x->{
            x.setUpdator(updator);
        });
        return staffGrowUpService.saveUpDate(itemPo);
    }


    @ApiOperation(value = "查询员工成长信息中培训信息",notes = "查询员工成长信息中培训信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    ComResponse<StaffUpTrainListDto> find(@RequestParam("staffNO")String staffNO) {
        return staffGrowUpService.find(staffNO);
    }

 /*   @ApiOperation(value = "删除员工成长信息中培训信息",notes = "删除员工成长信息中培训信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deleteTrain",method = RequestMethod.GET)
    ComResponse<Integer> deleteTrain(@Min(1) Integer id, @ApiIgnore @CurrentStaffNo String updator) {
        return staffGrowUpService.deleteTrain(id,updator);
    }

    @ApiOperation(value = "添加员工成长信息中培训信息", notes = "添加员工成长信息中培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/addTrain",method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工编号", required = true, paramType = "query")
    )
    ComResponse<Integer> addTrain(@RequestBody @Validated List<StaffUpTrainInsertPo> staff) {
        return staffGrowUpService.addTrain(staff);
    }

    @ApiOperation(value = "修改员工成长信息中培训信息", notes = "修改员工成长信息中培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateTrain",method = RequestMethod.POST)
    ComResponse<Integer> updateTrain (@RequestBody @Validated StaffUpTrainUpdatePo FamilyPo){
        return staffGrowUpService.updateTrain(FamilyPo);
    }
*/
    @ApiOperation(value = "保存员工成长信息中培训信息", notes = "保存员工成长信息中培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDateTrain",method = RequestMethod.POST)
    ComResponse<Integer>  saveUpDateTrain (@RequestBody @Validated StaffUpTrainItemPo trainItemPo ,@ApiIgnore @CurrentStaffNo String updator){
        trainItemPo.getInsertList().forEach(x->{
            x.setCreator(updator);
        });
        trainItemPo.getUpdateList().forEach(x->{
            x.setUpdator(updator);
        });
        trainItemPo.getDeleteList().forEach(x->{
            x.setUpdator(updator);
        });
        return staffGrowUpService.saveUpDateTrain(trainItemPo);
    }

}
