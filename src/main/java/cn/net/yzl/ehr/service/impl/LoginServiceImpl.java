package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.MD5util;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private StaffFeginService staffFeginService;
    @Override
    public ComResponse<StaffBaseDto> login(String userNo, String enName, String email, String phone,String password) {
        if((StrUtil.isBlank(userNo)&& StrUtil.isBlank(enName) && StrUtil.isBlank(email) && StrUtil.isBlank(phone))|| StrUtil.isBlank(password)){
            return ComResponse.fail(ResponseCodeEnums.PARAMS_EMPTY_ERROR_CODE.getCode(),ResponseCodeEnums.PARAMS_EMPTY_ERROR_CODE.getMessage());
        }
        Map<String, Object> map = new HashMap<>();
        if(StrUtil.isNotBlank(userNo)){
            map.put("userNo",userNo);
        }
        if(StrUtil.isNotBlank(enName)){
            map.put("enName",enName);
        }
        if(StrUtil.isNotBlank(email)){
            map.put("email",email);

        }
        if(StrUtil.isNotBlank(phone)){
            map.put("phone",phone);

        }
        ComResponse<StaffBaseDto> rep = staffFeginService.getOneByMap(map);

        if(rep.getData()!=null){
            String realPassWord = rep.getData().getPassword();
            String md5Password = SecureUtil.md5(password);
            if(!md5Password.equals(realPassWord)){
                return ComResponse.fail(ResponseCodeEnums.LOGIN_ERROR_CODE.getCode(), ResponseCodeEnums.LOGIN_ERROR_CODE.getMessage());
            }
        }

        return rep;
    }


    public static void main(String[] args) {
        String md5 = SecureUtil.md5("1234");
        System.err.println(md5);
    }
}
