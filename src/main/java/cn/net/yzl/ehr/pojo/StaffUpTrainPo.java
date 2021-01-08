package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_up_train
 * @author 
 */
@Data
@ApiModel(value = "StaffUpTrainPo", description = "员工培训记录")
public class StaffUpTrainPo implements Serializable {

    @ApiModelProperty(value = "员工培训记录编号",name = "id")
    private Integer id;

    @ApiModelProperty(value = "员工编号",name = "staffNo")
    private String staffNo;

    @ApiModelProperty(value = "开始时间",name = "startTime")
    private Date startTime;

    @ApiModelProperty(value = "结束时间",name = "endTime")
    private Date endTime;

    @ApiModelProperty(value = "培训名称",name = "content")
    private String content;

    @ApiModelProperty(value = "结果",name = "result")
    private String result;

    @ApiModelProperty(value = "是否获奖(0:否,1:是)",name = "flag")
    private Integer flag;

    @ApiModelProperty(value = "创建人",name = "creator")
    private String creator;

    @ApiModelProperty(value = "修改人",name = "updator")
    private String updator;

    private static final long serialVersionUID = 1L;


}