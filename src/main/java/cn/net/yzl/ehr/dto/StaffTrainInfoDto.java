package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class StaffTrainInfoDto  implements Serializable {

    @ApiModelProperty("异动类型:23离职-加急24入职25培训26调岗27转正28晋升29调薪30劝退31离职-自动68离职-正常69入岗72等级晋升73等级下调")
    private Integer type;

    @ApiModelProperty("异动类型名称")
    private String typeName;

    @ApiModelProperty("异动内容")
    private String content;

    @ApiModelProperty("调整前")
    private String adjustFront;

    @ApiModelProperty("调整后")
    private String adjustLater;

    @ApiModelProperty("异动时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date abnorTime;



}
