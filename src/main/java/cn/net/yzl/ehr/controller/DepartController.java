package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.authorization.annotation.UnAuthorization;
import cn.net.yzl.ehr.dto.DepartAttrDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.service.DepartService;
import cn.net.yzl.ehr.vo.DepartBusinessAttrVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import cn.net.yzl.staff.pojo.PostLevelUpdatePo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/depart")
@Api(value = "部门模块", tags = {"部门模块"})
@Validated
public class DepartController {

    @Autowired
    private DepartService departService;


    @ApiOperation(value = "获取部门的树状列表", notes = "获取部门的树状列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getTreeList", method = RequestMethod.GET)
    public ComResponse<List<DepartDto>> getTreeList() {
        return departService.getTreeList();
    }


    @ApiOperation(value = "获取子部门信息列表(1层)", notes = "获取子部门信息列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getChildById", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<DepartDto>> getChildById(@Min(1) @NotNull Integer departId) {
        return departService.getChildById(departId);
    }

    @ApiOperation(value = "添加部门", notes = "添加部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<DepartDto> add(@RequestBody @Validated DepartVO departVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        departVO.setCreator(staffNo);
        return departService.add(departVO);

    }

    @ApiOperation(value = "更新部门", notes = "更新部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody @Validated DepartUpdateVO departUpdateVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        departUpdateVo.setUpdator(staffNo);
        return departService.update(departUpdateVo);
    }

    @ApiOperation(value = "删除部门", notes = "删除部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<String> del(@Min(1) @NotNull Integer departId) {
        return departService.del(departId);
    }

    @ApiOperation(value = "根据层级获取部门集合", notes = "根据层级获取部门集合", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getChildByLevel", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "层级(1:集团,2:表示公司,3:事业部,4:表示中心)", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<DepartDto>> getChildByLevel(@Min(1) @NotNull Integer level) {
        return departService.getChildByLevel(level);
    }

    @ApiOperation(value = "根据组织id获取详情", notes = "根据组织id获取详情", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    ComResponse<DepartDto> getById(@Min(1) @NotNull Integer departId) {
        return departService.getById(departId);
    }


    @ApiOperation(value = "根据部门id集合修改顺序", notes = "根据部门id集合修改顺序", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateSortByIds", method = RequestMethod.POST)
    ComResponse<Integer> updateSortByIds(@RequestBody @NotEmpty List<Integer> ids) {
        return departService.updateSortByIds(ids);
    }

    @ApiOperation(value = "绑定业务属性", notes = "绑定业务属性", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/addBusinessAtrr", method = RequestMethod.POST)
    ComResponse<Integer> addBusinessAtrr(@RequestBody @Validated DepartBusinessAttrVO departBusinessAttrVO) {
        return departService.addBusinessAtrr(departBusinessAttrVO);
    }


    @ApiOperation(value = "获取部门属性列表", notes = "获取部门属性列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getDepartAttrList", method = RequestMethod.GET)
    ComResponse<List<DepartAttrDto>> getDepartAttrList() {
        return departService.getDepartAttrList();
    }

    @ApiOperation(value = "根据员工号获取部门列表(负责人)", notes = "根据员工号获取部门列表(负责人)", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getListByStaffNo", method = RequestMethod.GET)
    public ComResponse<List<cn.net.yzl.staff.dto.DepartDto>> getListByStaffNo(String staffNo){
        return departService.getListByStaffNo(staffNo);
    }
    @ApiOperation(value = "根据员工号获取部门列表(是否有最高权限)", notes = "根据员工号获取部门列表((是否有最高权限))", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "员工工号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "maxLevel", value = "是否最高权限 true是 false 否", required = true, dataType = "Boolean", paramType = "query")
    })
    @RequestMapping(value = "/getListByStaffNoData", method = RequestMethod.GET)
    ComResponse<List<cn.net.yzl.staff.dto.DepartDto>> getListByStaffNoData(@NotBlank String staffNo, Boolean maxLevel) {
        return departService.getListByStaffNoData(staffNo,maxLevel);
    }
}
