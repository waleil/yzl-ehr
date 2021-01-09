package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DepartResumeDictListPo {

    private ValidList<DepartResumeDictInsertPo> insertList;
    private ValidList<DepartResumeDictUpdatePo> updateList;
    private ValidList<DepartResumeDictDeletePo> deleteList;

    @Data
    public static class DepartResumeDictInsertPo{
        @ApiModelProperty(value = "名称", name = "name")
        @NotBlank
        private String name;
        @ApiModelProperty(value = "排序", name = "sort")
        @NotNull
        @Min(0)
        private Integer sort;
        @ApiModelProperty(value = "创建人", name = "creator",hidden = true)
        private String creator;
    }

    @Data
    public static class DepartResumeDictUpdatePo{
        @ApiModelProperty(value = "编号", name = "id")
        @NotNull
        @Min(0)
        private Integer id;
        @ApiModelProperty(value = "姓名", name = "name")
        @NotBlank
        private String name;
        @ApiModelProperty(value = "排序", name = "sort")
        @NotNull
        @Min(0)
        private Integer sort;
        @ApiModelProperty(value = "更改人", name ="updator",hidden = true)
        private String updator;
    }

    @Data
    public static class DepartResumeDictDeletePo{
        @ApiModelProperty(value = "编号", name = "id")
        @NotNull
        @Min(0)
        private Integer id;
        @ApiModelProperty(value = "更改人", name = "updator",hidden = true)
        private String updator;
    }

}
