package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.util.List;

@Data
public class StaffEduListDto {
    private String staffNo;
    private String staffName;
    private Integer dictcode;
    private String  value;
    private List<StaffEduDto> list;
}
