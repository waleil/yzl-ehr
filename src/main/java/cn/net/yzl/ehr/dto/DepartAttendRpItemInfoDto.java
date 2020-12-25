package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 考勤奖惩信息 考勤奖惩信息表
 */
@Data
public class DepartAttendRpItemInfoDto implements Serializable {

    /**
     * 部门id
     */
    private Integer attendRpItemId; // 奖惩项id
    private Integer departId;
    private String name;
    private Integer times; // 几次

    private List<DepartAttendRpDto> attendRpDtoList;



}