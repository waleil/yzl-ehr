package cn.net.yzl.ehr.vojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Data
public class QueryCoursewareParam {
    @ApiModelProperty(value = "课件名称")
    private String name;

    @ApiModelProperty(value = "课件类别编码")
    private int typeId;

    @ApiModelProperty(value = "课件使用科室编码")
    private int departId;

    @ApiModelProperty(value = "当前页码")
    private int pageNo;

    @ApiModelProperty(value = "单页显示数据条数")
    private int pageSize;
}
