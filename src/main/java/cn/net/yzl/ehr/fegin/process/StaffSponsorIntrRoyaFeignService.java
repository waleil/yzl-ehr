package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffSponsorIntrRoyaVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/25 20:47
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/staffSponsorIntrRoya")
public interface StaffSponsorIntrRoyaFeignService {


    @ApiOperation(value = "保存转介绍提成流程数据", notes = "保存转介绍提成流程数据")
    @PostMapping("v1/insertStaffSponsorIntrRoya")
    public ComResponse<ProcessApproveNode> insertStaffSponsorIntrRoya(@RequestBody StaffSponsorIntrRoyaVo staffSponsorIntrRoyaVo);


}
