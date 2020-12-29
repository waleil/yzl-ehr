package cn.net.yzl.ehr.vo;


import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;


@Data
public class DepartResumeItemPo {
    @ApiModelProperty(value = "部门编号", name = "departId",required = true)
    private Integer departId;
    @ApiModelProperty(value = "部门名称", name = "postId",required = true)
    private Integer postId;
    @Valid
    private ValidList<DepartResumeInsertPo> insertList;
    @Valid
    private ValidList<DepartResumeUpdatePo> updateList;
    @Valid
    private ValidList<DepartResumeDeletePo> deleteList;
}
