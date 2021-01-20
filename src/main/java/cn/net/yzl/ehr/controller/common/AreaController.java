package cn.net.yzl.ehr.controller.common;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.service.AreaService;
import cn.net.yzl.staff.dto.common.AreaDto;
import cn.net.yzl.staff.dto.common.CityDto;
import cn.net.yzl.staff.dto.common.ProvinceDto;
import cn.net.yzl.staff.dto.common.StreetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value="/area")
@RestController
@Api(value = "公共接口", tags = {"公共接口"})
public class AreaController {

    @Autowired
    private AreaService areaService;

    @ApiOperation(value = "区划字典-获取所有的省区划", notes = "区划字典-获取所有的省区划", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getProvinceList", method = RequestMethod.GET)
    public ComResponse<Page<ProvinceDto>> getProvinceList(){
        return areaService.getProvinceList();
    }

    @ApiOperation(value = "区划字典-获取所有的市区划", notes = "区划字典-获取所有的市区划", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getCityList", method = RequestMethod.GET)
    public ComResponse<Page<CityDto>> getCityList(String pid){
        return areaService.getCityList(pid);
    }

    @ApiOperation(value = "区划字典-获取所有的区县区划", notes = "区划字典-获取所有的区县区划", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getAreaList", method = RequestMethod.GET)
    public ComResponse<Page<AreaDto>> getAreaList(String cid){
        return areaService.getAreaList(cid);
    }

    @ApiOperation(value = "区划字典-获取所有的街道区划", notes = "区划字典-获取所有的街道区划", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getStreetList", method = RequestMethod.GET)
    public ComResponse<Page<StreetDto>> getStreetList(String aid){
        return areaService.getStreetList(aid);
    }
}
