package cn.net.yzl.ehr.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class DepartSocialPo implements Serializable {

    private Integer id;
    @NotNull(message = "部门id不能为空")
    private Integer departId;
    @NotNull(message = "岗位id不能为空")
    private Integer postId;
    private String postName;
    @NotNull(message = "区域id不能为空")
    private Integer zoneId;
    private String zoneName;
    @NotNull(message = "薪酬范围下限不能为空")
    private Integer salaryStart;
    @NotNull(message = "薪酬范围上限不能为空")
    private Integer salaryEnd;
    @NotNull(message = "缴纳基数不能为空")
    private Integer base;
    @NotNull(message = "缴纳开始时间不能为空")
    private Integer payStart;
    private Integer isDel;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String updator;

    @NotEmpty
    private List<DepartSocialPo> departSocialPoList;

}
