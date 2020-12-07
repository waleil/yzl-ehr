package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.service.DepartService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/depart")
@Api(value = "部门模块", tags = {"部门模块"})
public class DepartController {

    @Autowired
    private DepartService departService;


    @ApiOperation(value = "获取部门的树状列表", notes = "获取部门的树状列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getTreeList", method = RequestMethod.GET)
    public ComResponse<DepartDto> getTreeList() {
        return departService.getTreeList();
    }




}
