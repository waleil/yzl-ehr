package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.common.AreaFeginService;
import cn.net.yzl.ehr.service.AreaService;
import cn.net.yzl.staff.dto.common.AreaDto;
import cn.net.yzl.staff.dto.common.CityDto;
import cn.net.yzl.staff.dto.common.ProvinceDto;
import cn.net.yzl.staff.dto.common.StreetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaFeginService areaFeginService;

    @Override
    public ComResponse<Page<ProvinceDto>> getProvinceList() {
        return areaFeginService.getProvinceList();
    }

    @Override
    public ComResponse<Page<CityDto>> getCityList(String provinceId) {
        return areaFeginService.getCityList(provinceId);
    }

    @Override
    public ComResponse<Page<AreaDto>> getAreaList(String cityId) {
        return areaFeginService.getAreaList(cityId);
    }

    @Override
    public ComResponse<Page<StreetDto>> getStreetList(String areaId) {
        return areaFeginService.getStreetList(areaId);
    }
}
