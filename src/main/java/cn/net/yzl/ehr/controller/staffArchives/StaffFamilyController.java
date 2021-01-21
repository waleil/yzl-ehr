package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffFamilyDto;
import cn.net.yzl.ehr.dto.StaffFamilyListDto;
import cn.net.yzl.ehr.pojo.StaffFamilyInsertPo;
import cn.net.yzl.ehr.pojo.StaffFamilyItemPo;
import cn.net.yzl.ehr.pojo.StaffFamilyPo;
import cn.net.yzl.ehr.pojo.StaffFamilyUpdatePo;
import cn.net.yzl.ehr.service.StaffFamilyService;
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
import java.util.List;

@RestController
@RequestMapping("/staff/staffFamily")
@Api(value = "家人信息", tags = {"员工档案"})
@Valid
public class StaffFamilyController {
    @Autowired
    private StaffFamilyService staffFamilyService;

    @ApiOperation(value = "家人信息—查询员工家庭信息",notes = "查询员工家庭信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "staffNO", value = "员工工号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffFamilyListDto> findByStaffNo(@RequestParam("staffNO") String staffNO) {
        return staffFamilyService.findByStaffNo(staffNO);
    }
/*
    @ApiOperation(value = "删除信息",notes = "删除信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工家庭成员编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@Min(1) Integer id, @ApiIgnore @CurrentStaffNo String updator) {
        return staffFamilyService .deleteById(id,updator);
    }

    @ApiOperation(value = "修改信息", notes = "修改信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工家庭成员编号", required = true, paramType = "query")
    )
    ComResponse<Integer> insert(@RequestBody @Validated List<StaffFamilyInsertPo> staffFamilyInsertList) {
        return staffFamilyService.insert(staffFamilyInsertList);
    }
    @ApiOperation(value = "添加信息", notes = "添加信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody @Validated StaffFamilyUpdatePo FamilyPo){
        return staffFamilyService.update(FamilyPo);
    }*/
    @ApiOperation(value = "家人信息—保存员工家庭信息", notes = "保存信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody @Validated StaffFamilyItemPo staffFamilyPo, @ApiIgnore @CurrentStaffNo String updator){
        staffFamilyPo.getInsertList().forEach(x->{
            x.setCreator(updator);
        });
        staffFamilyPo.getUpdateList().forEach(x->{
            x.setUpdator(updator);
        });
        staffFamilyPo.getDeleteList().forEach(x->{
            x.setUpdator(updator);
        });

        return staffFamilyService.saveUpDate(staffFamilyPo);
    }
}
