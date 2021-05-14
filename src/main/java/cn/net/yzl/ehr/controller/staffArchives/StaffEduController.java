package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffEduService;
import cn.net.yzl.staff.dto.StaffEduListDto;
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
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/staff/staffEdu")
@Api(value = "教育经历", tags = {"员工档案"})
public class StaffEduController {
    @Autowired
    private StaffEduService staffEduService;

    @ApiOperation(value = "教育经历—查询员工教育信息",notes = "查询员工教育信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "StaffNo", value = "员工工号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffEduListDto> findByStaffNo(@RequestParam("StaffNo") @NotBlank String StaffNo) {
        return staffEduService.findByStaffNo(StaffNo);
    }

/*
    @ApiOperation(value = "删除员工教育经历",notes = "删除员工教育经历",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工教育经历编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") @Min(1) Integer id, @ApiIgnore @CurrentStaffNo String staffNo) {
        return staffEduService.deleteById(id,staffNo);
    }

    @ApiOperation(value = "添加员工教育经历", notes = "添加员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工教育经历编号", required = true, paramType = "query")
    )
    ComResponse<Integer> add(@RequestBody @Validated List<StaffEduInsertPo> insertList) {
        return staffEduService.add(insertList);
    }
    @ApiOperation(value = "修改员工教育经历", notes = "添加员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upaDteEdu",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody @Validated StaffEduUpdatePo updatePo){
        return staffEduService.update(updatePo);
    }

    */

    @ApiOperation(value = "教育经历—保存员工教育经历", notes = "保存员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody @Validated StaffEduItemPo itemPo ,@ApiIgnore @CurrentStaffNo String staffNo){
        itemPo.getInsertList().forEach(x->{
            x.setCreator(staffNo);
        });
        itemPo.getUpdateList().forEach(x->{
            x.setUpdator(staffNo);
        });
        itemPo.getDeleteList().forEach(x->{
            x.setUpdator(staffNo);
        });
        return staffEduService.saveUpDate(itemPo);
    }
}
