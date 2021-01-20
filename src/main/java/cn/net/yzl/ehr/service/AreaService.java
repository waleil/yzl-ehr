package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.common.AreaDto;
import cn.net.yzl.staff.dto.common.CityDto;
import cn.net.yzl.staff.dto.common.ProvinceDto;
import cn.net.yzl.staff.dto.common.StreetDto;


import java.util.List;

public interface AreaService {

    public ComResponse<Page<ProvinceDto>> getProvinceList();

    public ComResponse<Page<CityDto>> getCityList(String provinceId);

    public ComResponse<Page<AreaDto>> getAreaList( String cityId);

    public ComResponse<Page<StreetDto>> getStreetList(String areaId);

}
