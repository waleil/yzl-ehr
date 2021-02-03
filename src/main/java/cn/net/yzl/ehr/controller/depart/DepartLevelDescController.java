package cn.net.yzl.ehr.controller.depart;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.depart.DepartLevelDescFeginService;
import cn.net.yzl.staff.dto.depart.DepartLevelDescDto;
import cn.net.yzl.staff.vo.depart.DepartLevelDescUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departLevel")
@Api(value = "部门模块", tags = {"部门模块"})
public class DepartLevelDescController {

    @Autowired
    private DepartLevelDescFeginService departLevelDescFeginService;



    @ApiOperation(value = "架构级别-获取级别列表", notes = "架构级别-获取级别列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getDepartLevelList", method = RequestMethod.GET)
    ComResponse<List<DepartLevelDescDto>> getDepartLevelList() {
        return departLevelDescFeginService.getDepartLevelList();
    }

    @ApiOperation(value = "架构级别-修改", notes = "架构级别-修改", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody  List<DepartLevelDescUpdateVO> departLevelDescUpdateVOList) {
        return departLevelDescFeginService.update(departLevelDescUpdateVOList);
    }
}
