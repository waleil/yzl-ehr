package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "StaffFamilyPo", description = "员工家庭信息")
public class StaffFamilyPo implements Serializable {
    @ApiModelProperty(value = "员工家庭成员编号", name = "id")
    private Integer id;
    @ApiModelProperty(value = "工号(用户工号)", name = "id")
    private String staffNo;
    @ApiModelProperty(value = "姓名(家庭成员姓名)", name = "name")
    private String name;
    @ApiModelProperty(value = "与员工之间的关系", name = "relation")
    private String relation;
    @ApiModelProperty(value = "家庭成员的工作单位", name = "workUnit")
    private String workUnit;
    @ApiModelProperty(value = "家庭成员的联系电话", name = "phone")
    private String phone;
    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;
    @ApiModelProperty(value = "修改人", name = "updator",hidden = true)
    private String updator;






}