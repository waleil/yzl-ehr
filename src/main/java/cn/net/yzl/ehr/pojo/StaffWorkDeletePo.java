package cn.net.yzl.ehr.pojo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * staff_family
 * @author 
 */
@Data
public class StaffWorkDeletePo implements Serializable {
    /**
     * id 唯一标识
     */
    @NotNull
    @Min(1)
    private Integer id;


    /**
     * 修改人
     */
    @NotBlank
    private String updator;

}