package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StaffAddrListDto {
    @ApiModelProperty("地址类别：(0.户口所在地,1.现居地址)")
    private Integer type;
    @ApiModelProperty("省id")
    private Integer provinceId ;
    @ApiModelProperty("省名")
    private String provinceName ;
    @ApiModelProperty("市id")
    private Integer cityId;
    @ApiModelProperty("市名")
    private String cityName;
    @ApiModelProperty("(区/县)id")
    private Integer countyId;
    @ApiModelProperty("(区/县)名")
    private String countyName;
    @ApiModelProperty("街道/镇id")
    private Integer streetId;
    @ApiModelProperty("街道/镇名")
    private String streetName;
    @ApiModelProperty("详细信息")
    private String  address;

}