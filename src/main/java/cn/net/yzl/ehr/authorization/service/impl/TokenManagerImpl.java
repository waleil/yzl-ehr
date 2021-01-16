package cn.net.yzl.ehr.authorization.service.impl;

import cn.net.yzl.common.util.UUIDGenerator;
import cn.net.yzl.ehr.authorization.service.TokenManager;
import cn.net.yzl.ehr.config.redis.RedisUtil;
import cn.net.yzl.ehr.dto.StaffDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenManagerImpl implements TokenManager {

    private int sessionTimeout = 0;// 0永久有效  (有效期配置在配置文件 中)
    @Autowired
    private RedisUtil redisUtil;
    private String token = "token:"; // token前缀
    @Override
    public StaffDto create(StaffDto admin) {
        String no = admin.getNo();
        String tokenKey=token+no;
        redisUtil.set(tokenKey,token,sessionTimeout);
        return admin;
    }

    @Override
    public StaffDto get(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return (StaffDto) redisUtil.get(token + token);
    }

    @Override
    public boolean check(String token) {
        boolean isExists = redisUtil.hasKey(token + token);
        return isExists;
    }

    @Override
    public boolean delete(Long userNo) {
        redisUtil.del(token+userNo);
        return redisUtil.hasKey(token+userNo);
    }

    public void setRedisClient(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

}
