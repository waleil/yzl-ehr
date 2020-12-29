package cn.net.yzl.ehr.pojo;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DepartSocialInfoPo implements Serializable {

    private Integer id;
    private Integer socialId;
    @NotNull(message = "缴纳社保信息id不能为空")
    private Integer socialItemId;
    @NotNull(message = "社保项目名称不能为空")
    @NotEmpty(message = "社保项目名称不能为空")
    private String name;
    @NotNull(message = "个人缴纳不能为空")
    private Double person;
    @NotNull(message = "公司缴纳不能为空")
    private Double company;
    private Integer isDel;
    @NotNull(message = "缴纳开始时间不能为空")
    private Integer checkFlag;

}
