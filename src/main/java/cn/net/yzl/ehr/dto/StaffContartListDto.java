package cn.net.yzl.ehr.dto;

import cn.net.yzl.staff.dto.StaffContractFileDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class StaffContartListDto {
    //合同信息
    @Valid
    @ApiModelProperty(value="合同信息",name="staffContractDto")
    private StaffContractDto staffContractDto;
    //合同文件及资质
    @ApiModelProperty(value="合同文件及资质",name="staffContractFiles")
    private List<StaffContractFileDto> staffContractFiles;
}
