package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.util.List;

@Data
public class StaffUpTrainListDto {
    private String staffNo;
    private String staffName;
    private List<StaffFamilyDto> staffFamilyList;
}
