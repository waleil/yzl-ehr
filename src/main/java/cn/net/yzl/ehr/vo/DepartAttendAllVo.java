package cn.net.yzl.ehr.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DepartAttendAllVo implements Serializable {

    private Integer id;
    private String name;
    private List<DepartAttendVo> departAttendVoList;
}
