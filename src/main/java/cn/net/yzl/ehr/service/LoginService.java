package cn.net.yzl.ehr.service;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffBaseDto;

public interface LoginService {
    // 登录
    ComResponse<StaffBaseDto> login(String userNo, String enName, String email, String phone,String password);
}
