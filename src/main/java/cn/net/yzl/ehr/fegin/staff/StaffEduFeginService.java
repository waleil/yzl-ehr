package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-db")
public interface StaffEduFeginService {


    @ApiOperation(value = "查询员工教育经历",notes = "查询员工教育经历",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/findByStaffNo", method = RequestMethod.GET)
    ComResponse<List<StaffEduPo>> findByStaffNo(@RequestParam("staffNO")  String staffNO);

    @ApiOperation(value = "删除查询员工教育经历",notes = "删除查询员工教育经历",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")  Integer id,@RequestParam("updator") String updator);

    @ApiOperation(value = "添加查询员工教育经历", notes = "添加查询员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/add",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody  List<StaffEduInsertPo> staffEduInsertList);

    @ApiOperation(value = "修改查询员工教育经历", notes = "修改查询员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffEdu/upadteEdu",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffEduUpdatePo staffEduPo);

    @ApiOperation(value = "保存查询员工教育经历", notes = "保存查询员工教育经历", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/staffEdu/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffEduItemPo staffEduPo);
}
