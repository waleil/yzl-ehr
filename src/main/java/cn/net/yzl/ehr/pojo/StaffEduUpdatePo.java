package cn.net.yzl.ehr.pojo;

import cn.net.yzl.staff.pojo.uploadRelation.UploadRelationPo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * staff_edu
 * @author 
 */
@Data
public class StaffEduUpdatePo implements Serializable {

    @ApiModelProperty(value = "员工教育编号", name = "id")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    @NotBlank
    private String staffNo;

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty(value = "毕业学校", name = "school")

    private String school;

    @ApiModelProperty(value = "学历", name = "degree")

    @Min(0)
    private Integer degree;

    @ApiModelProperty(value = "专业/院系", name = "major")

    private String major;

  /*  @ApiModelProperty(value = "证书路径", name = "path")
    @NotBlank
    private String path;


    @ApiModelProperty(value = "持有证书", name = "certificate")
    @NotBlank
    private String certificate;*/

    private List<UploadRelationPo> uploadRelationPos;

    @ApiModelProperty(value = "修改人",hidden = true)
    private String updator;


    private static final long serialVersionUID = 1L;


}