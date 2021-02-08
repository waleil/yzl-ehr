package cn.net.yzl.ehr.controller.common;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.common.NationFeginService;
import cn.net.yzl.staff.dto.common.NationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value="/nation")
@RestController
@Api(value = "公共接口", tags = {"公共接口"})
public class NationController {

    @Autowired
    private NationFeginService nationFeginService;


    @ApiOperation(value = "民族字典-获取所有的民族编码", notes = "民族字典-获取所有的民族编码", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getAllNation", method = RequestMethod.GET)
    ComResponse<List<NationDto>> getAllNation(){
      return nationFeginService.getAllNation();
    }


}
