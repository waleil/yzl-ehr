package cn.net.yzl.ehr.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_attend_st
 * @author 
 */
@Data
public class DepartAttendStVO implements Serializable {
    /**
     * 部门id
     */
    @Min(1)
    @NotNull
    private Integer departId;

    /**
     * 结算日(每个月几号)
     */
    @Min(1)
    @Max(32)
    private Byte day;

}