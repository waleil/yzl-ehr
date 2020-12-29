package cn.net.yzl.ehr.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * depart_attend_ft
 * @author 
 */
@Data
@Setter
@Getter
public class DepartAttendFtDto implements Serializable {
    private Integer id;

    /**
     * 部门id
     */
    private Integer departId;

    /**
     * 名称
     */
    private String name;

    /**
     * 勾选标识(1:勾选,0:没有勾选)
     */
    private Byte checkFlag;


}