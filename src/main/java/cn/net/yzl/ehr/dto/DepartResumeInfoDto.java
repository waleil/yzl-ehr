package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 岗位表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:39:11
 */
@Data
@ApiModel(value="DepartResumeInfoDto",description="部门面试实体")
public class DepartResumeInfoDto implements Serializable {

    @ApiModelProperty(value="id",name="id")
    private Integer id;

    /**
     * 岗位名称
     */
    private String name;


    private List<DepartResumeDto> departResumeList;




}