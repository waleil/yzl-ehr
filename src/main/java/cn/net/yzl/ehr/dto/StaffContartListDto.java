package cn.net.yzl.ehr.dto;

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
    //电子版合同
    @Valid
    @ApiModelProperty(value="电子版合同",name="staffContractFileDtos")
    private List<StaffContractFileDto> staffContractFileDtos;
    //其他资质
    @Valid
    @ApiModelProperty(value="其他资质",name="staffContractFiles")
    private List<StaffContractFileDto> staffContractFiles;
}
