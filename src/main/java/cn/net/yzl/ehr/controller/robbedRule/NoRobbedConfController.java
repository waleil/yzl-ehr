package cn.net.yzl.ehr.controller.robbedRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.robbedRule.NoRobbedConfFeginMapper;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.robbedRule.NoRobbedConfDto;
import cn.net.yzl.staff.vo.robbedRule.NoRobbedConfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/noRobbedConf")
@Api(value = "一线管理", tags = {"一线管理"})
@Validated
public class NoRobbedConfController {

    @Autowired
    private NoRobbedConfFeginMapper noRobbedConfFeginMapper;

    @ApiOperation(value = "抢休配置-添加", notes = "抢休配置-添加", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<DepartDto> add(@RequestBody @Validated NoRobbedConfVO noRobbedConfVO) {
        return noRobbedConfFeginMapper.add(noRobbedConfVO);
    }



    @RequestMapping(value = "/getChildById", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始时间(yyyy-MM)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间(yyyy-MM)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "enable", value = "状态(1:启用,0:停用)", required = false, dataType = "Int", paramType = "query")
    })
    @ApiOperation(value = "抢休规则配置-列表", notes = "抢休规则配置-列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ComResponse<List<NoRobbedConfDto>> getNoRobbedConfList(String startTime, String endTime, Integer enable) {

        return noRobbedConfFeginMapper.getNoRobbedConfList(startTime,endTime,enable);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "抢休规则id", required = false, dataType = "Int", paramType = "query")

    })
    @ApiOperation(value = "抢休规则配置-停用", notes = "抢休规则配置-停用", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ComResponse<String> stop( Integer id) {

        return noRobbedConfFeginMapper.stop(id);
    }
}
