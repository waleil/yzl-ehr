package cn.net.yzl.ehr.pojo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 可缴纳社保项目
 */
@Data
@Validated
public class DepartSocialTypePo implements Serializable {

    private Integer id;
    @NotNull
    private Integer departId;
    @NotBlank(message = "社保项目名称不能为空")
    private String name;
    private Integer isDel;
    @NotNull
    private Integer checkFlag;
}
