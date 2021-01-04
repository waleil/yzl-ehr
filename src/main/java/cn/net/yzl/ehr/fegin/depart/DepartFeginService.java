package cn.net.yzl.ehr.fegin.depart;

import cn.net.yzl.common.entity.ComResponse;
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

import java.util.List;

/**
 * 部门的 fegin client
 */
@FeignClient(name = "yzl-staff-api")
//@FeignClient(value = "depart",url = "${fegin.api.url}")
@Repository
public interface DepartFeginService {



    // 获取部门列表
    @RequestMapping(value = "/depart/getTreeList", method = RequestMethod.GET)
    ComResponse<DepartDto> getTreeList();
    @RequestMapping(value = "/depart/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody DepartVO departVO);
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
}
