package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.staff.StaffPasswordRuleDto;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.staff.StaffPasswordRuleInsertVO;
import cn.net.yzl.staff.vo.staff.StaffPasswordRuleParams;
import cn.net.yzl.staff.vo.staff.StaffPasswordRuleUpdateVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@FeignClient(value = "staff",url = "${fegin.db.url}/StaffPasswordRule")
public interface StaffPasswordRuleFeginService {
    @RequestMapping(value = "/getStaffPasswordRulePage", method = RequestMethod.POST)
    ComResponse<Page<StaffPasswordRuleDto>> getStaffPasswordRulePage(@RequestBody
                                                                             StaffPasswordRuleParams staffPasswordRuleParams) throws IllegalAccessException;

    @RequestMapping(value = "/enable", method = RequestMethod.GET)
    ComResponse<String> enable(@RequestParam("id") Integer id, @RequestParam("enable")  Integer enable) throws IllegalAccessException;
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    ComResponse<String> del(@RequestParam("id") Integer id) throws IllegalAccessException;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ComResponse<String> create(@RequestBody StaffPasswordRuleInsertVO staffPasswordRuleInsertVO) throws IllegalAccessException;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody StaffPasswordRuleUpdateVO staffPasswordRuleUpdateVO) throws IllegalAccessException;
}
