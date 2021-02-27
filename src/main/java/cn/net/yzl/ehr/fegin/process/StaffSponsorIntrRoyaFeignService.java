package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.StaffSponsorIntrRoyaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/25 20:47
 */
@FeignClient(value = "staffSponsorIntrRoya",url = "${fegin.db.url}/staffSponsorIntrRoya")
public interface StaffSponsorIntrRoyaFeignService {


    @ApiOperation(value = "保存转介绍提成流程数据",notes = "保存转介绍提成流程数据")
    @PostMapping("v1/insertStaffSponsorIntrRoya")
    public ComResponse<Integer> insertStaffSponsorIntrRoya(@RequestBody StaffSponsorIntrRoyaVo staffSponsorIntrRoyaVo);



}
