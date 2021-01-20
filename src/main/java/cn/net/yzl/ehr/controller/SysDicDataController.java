package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping(value="/sysDic")
//@RestController
//@Api(value = "字典数据", tags = {"字典数据接口"})
public class SysDicDataController {

  /*  @Autowired
    private SysDictDataService sysDictDataService;

    *//**
     * 通过主键获取字典
     * @param dictCode
     * @return
     *//*
    @ApiOperation(value = "根据主键获取字典", notes = "根据主键获取字典", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictCode", value = "字典主键编号", required = true, paramType = "query")
    })
    @RequestMapping(value = "getDicByCode",method = RequestMethod.GET)
    ComResponse<SysDictDataDto> selectByPrimaryKey(Integer dictCode){
      return  sysDictDataService.selectByPrimaryKey(dictCode);
    }

    @ApiOperation(value = "根据字典编码获取字典", notes = "根据字典编码获取字典", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictLabel", value = "字典编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dictType", value = "字典类型", required = true, paramType = "query")
    })
    @RequestMapping(value = "/selectByLabel", method = RequestMethod.GET)
    ComResponse<SysDictDataDto> selectByLabel(@RequestParam String dictLabel,@RequestParam String dictType){
      return  sysDictDataService.selectByLabel(dictLabel,dictType);
    }

    @ApiOperation(value = "根据类型获取字典集合", notes = "根据类型获取字典集合", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "字典类型", required = true, paramType = "query")
    })
    @RequestMapping(value = "/selectByType", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> selectByType(String dictType){
      return sysDictDataService.selectByType(dictType);
    }

    @ApiOperation(value = "根据主键删除主键", notes = "根据主键删除主键", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictCode", value = "字典主键编号", required = true, paramType = "query")
    })
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    ComResponse<Integer> deleteByPrimaryKey(Integer dictCode){
      return sysDictDataService.deleteByPrimaryKey(dictCode);
    }

    @ApiOperation(value = "新增字典", notes = "新增字典", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertSelective(@RequestBody SysDictDataPo record){
      return sysDictDataService.insertSelective(record);
    }

    @ApiOperation(value = "编辑更改字典", notes = "编辑更改字典", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    ComResponse<Integer> updateByPrimaryKeySelective(@RequestBody SysDictDataPo record){
      return sysDictDataService.updateByPrimaryKeySelective(record);
    }
*/

}
