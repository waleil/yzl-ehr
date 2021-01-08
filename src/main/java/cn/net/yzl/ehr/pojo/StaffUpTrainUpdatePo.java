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
public class StaffUpTrainUpdatePo implements Serializable {


    /**
     * 员工表工号
     */
    @ApiModelProperty(value = "id")
    @NotNull
    @Min(0)
    private Integer id;

    /**
     * 员工表工号
     */
    @ApiModelProperty(value = "员工表工号")
    @NotBlank
    private String staffNo;

    /**
     * 开始时间
     */

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 培训名称
     */
    @ApiModelProperty(value = "培训名称")
    @NotBlank
    private String content;

    /**
     * 结果
     */
    @ApiModelProperty(value = "结果")
    @NotBlank
    private String result;

    /**
     * 是否获奖(0:否,1:是)
     */
    @ApiModelProperty(value = "是否获奖(0:否,1:是)")
    @NotNull
    private Integer flag;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    @NotBlank
    private String updator;


    private static final long serialVersionUID = 1L;


}