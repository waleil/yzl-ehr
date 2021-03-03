package cn.net.yzl.ehr.fegin.oauth;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttrDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.vo.DepartBusinessAttrVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 认证
 */
@FeignClient(name = "yzl-oauth")
@Repository
public interface OauthFeginService {


    // token认证
    @RequestMapping(value = "/user/checkToken", method = RequestMethod.GET)
    ComResponse<String> checkToken(@RequestParam("token") String token);
}
