package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.SysDictDataDto;
import cn.net.yzl.ehr.fegin.sysDictData.SysDictDataFeginService;
import cn.net.yzl.ehr.service.SysDictService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/sysDic")
@Api(value = "字典接口", tags = {"字典接口"})
@Valid
public class SysDictController {

    @Autowired
    private SysDictDataFeginService sysDictDataFeginService;

    @ApiOperation(value = "根据类型获取字典集合", notes = "根据类型获取字典集合", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "字典类型", required = true, paramType = "query")
    })
    @RequestMapping(value = "/getByType", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> getByType(@NotBlank String dictType){
        return sysDictDataFeginService.getByType(dictType);
    }


}
