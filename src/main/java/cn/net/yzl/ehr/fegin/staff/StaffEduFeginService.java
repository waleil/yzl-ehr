package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.StaffEduInsertPo;
import cn.net.yzl.ehr.pojo.StaffEduItemPo;
import cn.net.yzl.ehr.pojo.StaffEduUpdatePo;
import cn.net.yzl.staff.dto.StaffEduListDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface StaffEduFeginService {


    @ApiOperation(value = "查询员工教育经历", notes = "查询员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffEduListDto> findByStaffNo(@RequestParam("staffNO") String staffNO);

    @ApiOperation(value = "删除员工教育经历", notes = "删除员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/deleteById", method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @RequestParam("updator") String updator);

    @ApiOperation(value = "添加员工教育经历", notes = "添加员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/add", method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody List<StaffEduInsertPo> staffEduInsertList);

    @ApiOperation(value = "修改员工教育经历", notes = "修改员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/upaDteEdu", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody StaffEduUpdatePo staffEduPo);

    @ApiOperation(value = "保存员工教育经历", notes = "保存员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/saveUpDate", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffEduItemPo staffEduPo);
}
