package cn.net.yzl.ehr.fegin.ding;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "yzl-staff-service")
@Repository
public interface DingTalkDepartFeginService {

    // 获取部门列表
    @RequestMapping(value = "/dingTalk/dingDepartToEhr", method = RequestMethod.GET)
    ComResponse<Boolean> dingDepartToEhr(@RequestParam("departId") String departId);
}
