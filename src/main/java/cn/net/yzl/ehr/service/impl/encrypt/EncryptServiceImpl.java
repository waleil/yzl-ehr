package cn.net.yzl.ehr.service.impl.encrypt;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.encrypt.EncryptFeignService;
import cn.net.yzl.ehr.service.encrypt.EncryptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EncryptServiceImpl implements EncryptService {

    private static final Logger logger = LoggerFactory.getLogger(EncryptServiceImpl.class);

    @Autowired
    private EncryptFeignService encryptFeignService;

    @Override
    public ComResponse<Integer> encryptExecute() {
        return encryptFeignService.encryptExecute();
    }

}
