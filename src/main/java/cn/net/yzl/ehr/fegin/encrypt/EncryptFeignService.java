package cn.net.yzl.ehr.fegin.encrypt;

import cn.net.yzl.common.entity.ComResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@FeignClient(value = "EncryptFeign",url = "localhost:38080/encrypt")
//@RefreshScope
public interface EncryptFeignService {

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    ComResponse<Integer> encryptExecute();
}
