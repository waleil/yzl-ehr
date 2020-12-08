package cn.net.yzl.ehr.authorization.service;

import cn.net.yzl.ehr.dto.StaffDto;

/**
 * token操作接口
 *
 * @author shen
 *
 */
public interface TokenManager {

    /**
     * 创建token
     *
     * @param admin
     * @return
     */
    public StaffDto create(StaffDto admin);

    /**
     * 根据token获取登录帐号
     *
     * @param token
     * @return
     */
    public StaffDto get(String token);

    /**
     * 检查token是否有效
     *
     * @param token
     * @return
     */
    public boolean check(String token);

    /**
     * 清除token
     *
     * @param token
     * @return
     */
    public boolean delete(Long userNo);
}

