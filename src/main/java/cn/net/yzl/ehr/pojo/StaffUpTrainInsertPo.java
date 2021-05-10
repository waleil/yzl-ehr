package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * staff_up_train
 * @author 
 */
@Data
public class StaffUpTrainInsertPo implements Serializable {


    @ApiModelProperty(value = "员工表工号")
    @NotBlank
    private String staffNo;

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;


    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


    @ApiModelProperty(value = "培训名称")

    private String content;


    @ApiModelProperty(value = "结果")

    private String result;


    @ApiModelProperty(value = "是否获奖(0:否,1:是)")
    private Integer flag;


    @ApiModelProperty(value = "创建人",hidden = true)
    private String creator;


    private static final long serialVersionUID = 1L;


}