package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@ApiModel(value = "CoursewareDto", description = "培训课件")
@Data
public class CoursewareDto implements Serializable {

    @ApiModelProperty("课件id")
    private Integer id;

    @ApiModelProperty("课件名称")
    private String name;


    @ApiModelProperty("课件描述")
    private String desc;

    @ApiModelProperty("附件路径")
    private String attachmentPath;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人编号")
    private Integer creator;

    @ApiModelProperty("更改时间")
    private String updateTime;

    @ApiModelProperty("更改人编号")
    private Integer updator;

    @ApiModelProperty("启用状态：0：待审核，1：审核通过待启用，2：已启用，3：已撤销")
    private int state;

    //适用部门
    private List<CoursewareDepartParam> departList;

    //课件种类
    private List<CoursewareCategoryParam> categoryList;

    @Data
    public static class  CoursewareCategoryParam {
        private int typeId;
        private String typeName;
    }


    @Data
    public static class CoursewareDepartParam {
        private  String departId;
        private  String departName;
    }


}
