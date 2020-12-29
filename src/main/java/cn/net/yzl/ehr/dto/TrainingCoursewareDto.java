package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "CoursewareDto", description = "培训课件")
public class TrainingCoursewareDto implements Serializable {
    @ApiModelProperty(value = "课件编号")
    private Integer coursewareId;
    @ApiModelProperty(value = "课件名称")
    private String coursewareName;
}
