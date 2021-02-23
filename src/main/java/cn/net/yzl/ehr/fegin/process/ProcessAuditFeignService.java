package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.ProcessAuditVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}/process")
@RefreshScope
public interface ProcessAuditFeignService {

    @RequestMapping(value = "/audit/update/state", method = RequestMethod.POST)
    ComResponse<Integer> updateProcessAuditState (@RequestBody @Validated ProcessAuditVo processAuditVo);
}
