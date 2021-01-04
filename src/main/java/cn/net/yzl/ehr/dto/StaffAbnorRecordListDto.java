package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 员工异动信息记录表
 * 
 * @author
 * @date： 2020-12-30 21:11:37
 */
@Data
public class StaffAbnorRecordListDto {

    @ApiModelProperty("员工工号")
    private String staffNo;

    @ApiModelProperty("员工姓名")
    private String staffName;

    private List<StaffAbnorRecordDto> staffAbnorRecordList;

    
}