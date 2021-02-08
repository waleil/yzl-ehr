package cn.net.yzl.ehr.fegin.common;



import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.common.AreaDto;
import cn.net.yzl.staff.dto.common.CityDto;
import cn.net.yzl.staff.dto.common.ProvinceDto;
import cn.net.yzl.staff.dto.common.StreetDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(value = "area",url = "${fegin.area.url}")
public interface AreaFeginService {

    @RequestMapping(value = "/province/getProvinceList", method = RequestMethod.GET)
    public ComResponse<Page<ProvinceDto>> getProvinceList();

    @RequestMapping(value = "/city/getCityList", method = RequestMethod.GET)
    public ComResponse<Page<CityDto>> getCityList(@RequestParam("provinceId") String provinceId);

    @RequestMapping(value = "/area/getAreaList", method = RequestMethod.GET)
    public ComResponse<Page<AreaDto>> getAreaList(@RequestParam("cityId") String cityId);

    @RequestMapping(value = "/street/getStreetList", method = RequestMethod.GET)
    public ComResponse<Page<StreetDto>> getStreetList(@RequestParam("areaId") String areaId);


}
