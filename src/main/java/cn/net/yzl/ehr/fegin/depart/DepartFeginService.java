package cn.net.yzl.ehr.fegin.depart;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttrDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.vo.DepartBusinessAttrVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 部门的 fegin client
 */
//@FeignClient(name = "yzl-staff-api")
//@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "depart",url="http://localhost:38080/")
@FeignClient(value = "depart",url = "${fegin.db.url}")
@Repository
public interface DepartFeginService {

    // 获取部门列表
    @RequestMapping(value = "/depart/getTreeList", method = RequestMethod.GET)
    ComResponse<DepartDto> getTreeList();
    @RequestMapping(value = "/depart/add", method = RequestMethod.POST)
    ComResponse<DepartDto> add(@RequestBody DepartVO departVO);
    @RequestMapping(value = "/depart/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody DepartUpdateVO departUpdateVO);
    @RequestMapping(value = "/depart/del", method = RequestMethod.GET)
    ComResponse<String> del(@RequestParam("departId") Integer departId);
    @RequestMapping(value = "/depart/getChildById", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getChildById(@RequestParam("departId") Integer departId);
    @RequestMapping(value = "/depart/getChildByLevel", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getChildByLevel(@RequestParam("level") Integer level);


    // 根据部门id获取
    @RequestMapping(value = "/depart/getById", method = RequestMethod.GET)
    ComResponse<DepartDto> getById(@RequestParam("departId") Integer departId);


    @RequestMapping(value = "/depart/updateSortByIds", method = RequestMethod.POST)
    ComResponse<Integer> updateSortByIds(@RequestBody List<Integer> ids);

    @ApiOperation(value = "绑定业务属性", notes = "绑定业务属性", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/depart/addBusinessAtrr", method = RequestMethod.POST)
    ComResponse<Integer> addBusinessAtrr(@RequestBody @Validated DepartBusinessAttrVO departBusinessAttrVO);

    @ApiOperation(value = "获取部门属性列表", notes = "获取部门属性列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/depart/getDepartAttrList", method = RequestMethod.GET)
    ComResponse<List<DepartAttrDto>> getDepartAttrList();

    @ApiOperation(value = "根据员工号获取部门列表(负责人)", notes = "根据员工号获取部门列表(负责人)", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/depart/getListByStaffNo", method = RequestMethod.GET)
    ComResponse<List<cn.net.yzl.staff.dto.DepartDto>> getListByStaffNo(@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "根据员工号获取部门ID集合(负责人)", notes = "根据员工号获取部门ID集合(负责人)", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getDepartListByStaffNo", method = RequestMethod.GET)
    ComResponse<List<Integer>> getDepartListByStaffNo(@RequestParam("staffNo")  String staffNo) ;
}
