package cn.net.yzl.ehr.dto;

import cn.net.yzl.ehr.pojo.AttendFalsePunishPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "SysAttendFalsePunishDto",description = "假勤和惩罚接口")
public class SysAttendFalsePunishDto {
    @ApiModelProperty(value = "假勤类型集合",name = "sysDictDataDtoList")
    private List<SysDictDataDto> sysDictDataDtoList;

    @ApiModelProperty(value = "假勤惩罚规则列表",name = "attendFalsePunishPoList")
    private List<AttendFalsePunishPo> attendFalsePunishPoList;

}
