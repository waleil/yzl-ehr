package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "DepartSocialPo", description = "社保信息")
public class DepartSocialPo implements Serializable{

    @ApiModelProperty(value = "主键id(新增没有值,编辑时有值)",name = "id")
    private Integer id;

    @ApiModelProperty(value = "部门id",name = "departId")
    @NotNull
    private Integer departId;

    @ApiModelProperty(value = "岗位id",name = "postId")
    @NotNull
    private Integer postId;

    @ApiModelProperty(value = "岗位名称",name = "postName")
    private String postName;

    @ApiModelProperty(value = "缴纳地区id",name = "zoneId")
    @NotNull
    private Integer zoneId;

    @ApiModelProperty(value = "缴纳地区名称",name = "zoneName")
    private String zoneName;

    @ApiModelProperty(value = "薪酬范围下限",name = "salaryStart")
    @NotNull
    @Min(value = 0)
    private Integer salaryStart;

    @ApiModelProperty(value = "薪酬范围上限,无上限限制用-1代替",name = "salaryEnd")
    @Min(value = -1)
    private Integer salaryEnd;

    @ApiModelProperty(value = "缴纳基数",name = "base")
    @Min(0)
    private Integer base;

    @ApiModelProperty(value = "缴纳开始时间(1:入职及缴纳,2:转正后及缴纳)",name = "payStart")
    @NotNull
    private Integer payStart;

    @ApiModelProperty(value = "是否启用,0:否,1:是(1:也表示立即生效的)",name = "enable")
    private Integer enable;

    @ApiModelProperty(value = "多少日后生效",name = "effectDay")
    private Integer effectDay;

    @ApiModelProperty(value = "生效时间(前端不需要赋值)",name = "effectTime")
    private LocalDate effectTime;

    @ApiModelProperty(value = "创建人",name = "creator")
    @NotNull
    private String creator;

    @ApiModelProperty(value = "修改人",name = "updator")
    private String updator;

    @ApiModelProperty(value = "社保详细信息",name = "departSocialInfoPoList")
    private List<DepartSocialInfoPo> departSocialInfoPoList;


}
