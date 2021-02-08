package cn.net.yzl.ehr.controller.robbedRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.robbedRule.ChooseClassConfFeginMapper;
import cn.net.yzl.staff.dto.robbedRule.ChooseClassConfDto;
import cn.net.yzl.staff.vo.robbedRule.ChooseClassConfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chooseClassConf")
@Api(value = "一线管理", tags = {"一线管理"})
@Validated
public class ChooseClassConfController {

    @Autowired
    private ChooseClassConfFeginMapper chooseClassConfFeginMapper;

    @ApiOperation(value = "选班配置-添加", notes = "选班配置-添加", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody @Validated ChooseClassConfVO chooseClassConfVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        chooseClassConfVO.setCreator(staffNo);
        return chooseClassConfFeginMapper.add(chooseClassConfVO);
    }



    @RequestMapping(value = "/getChooseClassConfList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始时间(yyyy-MM)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间(yyyy-MM)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "enable", value = "状态(1:启用,0:停用)", required = false, dataType = "Int", paramType = "query")
    })
    @ApiOperation(value = "选班配置-列表", notes = "选班配置-列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ComResponse<List<ChooseClassConfDto>> getChooseClassConfList(String startTime, String endTime, Integer enable) {

        return chooseClassConfFeginMapper.getChooseClassConfList(startTime,endTime,enable);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "选班规则id", required = true, dataType = "Int", paramType = "query")

    })
    @ApiOperation(value = "选班配置-停用", notes = "选班配置-停用", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ComResponse<String> stop( Integer id) {

        return chooseClassConfFeginMapper.stop(id);
    }
}
