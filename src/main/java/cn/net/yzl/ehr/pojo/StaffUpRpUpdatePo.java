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
 * staff_up_rp
 * @author 
 */
@Data
public class StaffUpRpUpdatePo implements Serializable {

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
     * 奖惩内容
     */
    @ApiModelProperty(value = "奖惩内容")
    @NotBlank
    private String content;

    /**
     * 奖惩结果
     */
    @ApiModelProperty(value = "奖惩结果")
    @NotBlank
    private String result;

    /**
     * 奖/惩 1.奖励 2.惩罚
     */
    @ApiModelProperty(value = "奖/惩 (1.奖励 2.惩罚)")
    @NotNull
    private Integer flag;




    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人唯一标识",hidden = true)
    @NotBlank
    private String updator;


    private static final long serialVersionUID = 1L;


}