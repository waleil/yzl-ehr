package cn.net.yzl.ehr.fegin.processActiveService;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.personApprove.ApproveInviteDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveProcessListDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="processsInvite",url="localhost:38080/processsInvite")
public interface saveProcessService {
    @PostMapping("v1/saveProcessInviteInfo")
    @ApiOperation(value = "保存招聘信息")
    ComResponse<Boolean> saveProcessInviteInfo(@RequestBody @Validated ApproveInviteDTO approveInviteDTO);

}
