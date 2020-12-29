package cn.net.yzl.ehr.vo;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public  class DepartResumeDeletePo implements Serializable {

    @ApiModelProperty("id")
    @NotNull
    @Min(1)
    private Integer id;



    @ApiModelProperty("更新人唯一标识")
    @NotBlank
    private String updator;




    private static final long serialVersionUID = 1L;

}

