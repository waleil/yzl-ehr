package cn.net.yzl.ehr.fegin.personApprove;

import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.personApprove.ApproveInfoListDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveQueryDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="personApprove",url="${fegin.db.url}/personApprove")
public interface PersonApproveClient {

    @PostMapping("v1/getApproveInfoListDTOList")
    @ApiOperation(value = "审批查询")
    public Comparable<Page<ApproveInfoListDTO>> findApproveInfo(@RequestBody ApproveQueryDTO approveQueryDTO);
}
