package cn.net.yzl.ehr.fegin.encrypt;

import cn.net.yzl.common.entity.ComResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}/encrypt")
public interface EncryptFeignService {

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    ComResponse<Integer> encryptExecute();
}
