package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.util.List;

@Data
public class StaffQuaListDto {
    private String staffNo;
    private String staffName;
    private List<StaffQuaDto> staffQuaList;
}
