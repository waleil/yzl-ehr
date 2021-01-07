package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * depart
 *
 * @author
 */
@Data
@JsonIgnoreProperties(value = {"handler"})
@ApiModel(value = "DepartAttrDto", description = "部门业务属性实体")
public class DepartAttrDto implements Serializable {

    @ApiModelProperty(value = "业务属性id", name = "attrCode")
    private Integer attrCode;
    @ApiModelProperty(value = "业务属性名称", name = "attrCodeName")
    private String attrCodeName;
    @ApiModelProperty(value = "部门集合list", name = "departList")
    private List<DepartDto> departList;


}