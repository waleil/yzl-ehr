package cn.net.yzl.ehr.vo;

import cn.net.yzl.ehr.dto.DepartResumeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 岗位表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:39:11
 */
@Data
@ApiModel(value="DepartResumeInfoVO",description="部门面试实体")
public class DepartResumeInfoVO implements Serializable {

    @ApiModelProperty(value="岗位id",name="岗位id")
    @NotNull
    @Min(0)
    private Integer postId;

    @ApiModelProperty(value="部门id",name="departId")
    @NotNull
    @Min(0)
    private Integer departId;

    private List<DepartResumeVO> departResumeList;




}