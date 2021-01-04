package cn.net.yzl.ehr.dto;


import cn.net.yzl.ehr.pojo.DepartAttendPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "DepartAttendDto", description = "部门假勤配置")
public class DepartAttendDto implements Serializable {
    @ApiModelProperty(value = "假勤类型集合",name = "sysDictDataDtoList")
    private List<SysDictDataDto> sysDictDataDtoList;

    @ApiModelProperty(value = "修改后的数据",name = "departAttendPoList")
    private List<DepartAttendPo> departAttendPoList;

    @ApiModelProperty(value = "修改前的数据",name = "beforeDepartAttendPoList")
    private List<DepartAttendPo> beforeDepartAttendPoList;

}
