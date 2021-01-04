package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "DepartAttendInsertAllVo", description = "部门假勤配置信息")
public class DepartAttendInsertAllVo implements Serializable {

    @ApiModelProperty(value = "是否选择立即生效(0代表否,1代表是)",name = "enable")
    private Integer enable;
    @ApiModelProperty(value = "生效时间(当选择立即生效时,effectDay为null,互斥)",name = "effectDay")
    private Integer effectDay;
    @ApiModelProperty(value = "部门id",name = "departId")
    private Integer departId;
    @ApiModelProperty(value = "新增假勤配置信息集合",name = "insertDatas")
    @NotEmpty
    private List<DepartAttendVo> insertDatas;

}
