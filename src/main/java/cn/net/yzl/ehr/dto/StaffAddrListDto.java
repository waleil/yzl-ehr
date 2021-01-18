package cn.net.yzl.ehr.dto;

import lombok.Data;

@Data
public class StaffAddrListDto {
    private Integer type;
    private Integer provinceId ;
    private String provinceName ;
    private Integer cityId;
    private String cityName;
    private Integer countyId;
    private String countyName;
    private Integer streetId;
    private String streetName;
    private String  address;

}