package cn.net.yzl.ehr.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DepartSalarySettlePo implements Serializable {
    private Integer id;
    @NotNull
    private Integer departId;
    @NotNull
    private Integer issueDate;
    @NotNull
    private Integer settleStart;
    @NotNull
    private Integer settleEnd;
    private Integer isDel;
}
