package cn.net.yzl.ehr.controller;

import cn.net.yzl.ehr.pojo.SysDict;
import cn.net.yzl.ehr.service.SysDictService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysDict")
@Api(value = "字典接口", tags = {"字典接口"})
public class SysDictController {

    @Autowired
    private SysDictService sysDictServiceImpl;

    @ApiOperation(value="根据id删除字典数据",notes="根据id伤处字典数据",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name="id",value="id",required=true,dataType="int",paramType="query")
    )
    @RequestMapping(value = "/deleteSysDictById", method = RequestMethod.POST)
    int deleteByPrimaryKey(Integer id){
     return sysDictServiceImpl.deleteByPrimaryKey(id);
    }



    @ApiOperation(value="增加字典记录",notes="增加字典记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /*@ApiImplicitParams(
            @ApiImplicitParam(name="record",value="record",required=true,dataType="String",paramType="query")
    )*/
    @RequestMapping(value = "/insertSysDictSelective", method = RequestMethod.POST)
    int insertSelective(SysDict record){
     return sysDictServiceImpl.insertSelective(record);
    }

    @ApiOperation(value="根据id查询字典记录",notes="根据id查询字典记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name="id",value="id",required=true,dataType="int",paramType="query")
    )
    @RequestMapping(value = "/getSysDictById", method = RequestMethod.GET)
    public SysDict selectByPrimaryKey(Integer id){
     return sysDictServiceImpl.selectByPrimaryKey(id);
    }

    @ApiOperation(value="根据id更改字典记录",notes="根据id更改字典记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /*@ApiImplicitParams(
            @ApiImplicitParam(name="record",value="record",required=true,dataType="String",paramType="query")
    )*/
    @RequestMapping(value = "/updateSysDictByIdSelective", method = RequestMethod.POST)
    int updateByPrimaryKeySelective(SysDict record){
     return sysDictServiceImpl.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value="根据type查询对应字典条目下的所有记录",notes="根据type查询对应字典条目下的所有记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name="type",value="type",required=true,dataType="String",paramType="query")
    )
    @RequestMapping(value = "/getSysDictListByType", method = RequestMethod.GET)
    public List selectByType(String type){
        return sysDictServiceImpl.selectByType(type);
    }
    /*int updateByPrimaryKey(SysDict record){
     return sysDictServiceImpl.updateByPrimaryKey(record);
    }

     @ApiOperation(value="增加字典记录",notes="增加字典记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name="字典记录",value="record",required=true,dataType="String",paramType="query")
    )
    @RequestMapping(value = "/insertSysDict", method = RequestMethod.GET)
    int insert(SysDict record){
     return sysDictServiceImpl.insert(record);
    }*/
}
