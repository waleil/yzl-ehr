package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.StaffLoanVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/26 22:25
 */
@FeignClient(value = "staffLoan",url = "${fegin.db.url}/staffLoan")
public interface StaffLoanFeignService {


    @PostMapping("v1/insertStaffLoan")
    public ComResponse<Integer> insertStaffLoan(StaffLoanVo staffLoanVo);
}
