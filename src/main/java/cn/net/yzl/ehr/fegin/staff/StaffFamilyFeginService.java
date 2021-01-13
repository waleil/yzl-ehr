package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffFamilyDto;
import cn.net.yzl.ehr.dto.StaffFamilyListDto;
import cn.net.yzl.ehr.pojo.StaffFamilyInsertPo;
import cn.net.yzl.ehr.pojo.StaffFamilyItemPo;
import cn.net.yzl.ehr.pojo.StaffFamilyPo;
import cn.net.yzl.ehr.pojo.StaffFamilyUpdatePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "staff",url = "${fegin.db.url}")
@Repository
//@FeignClient(name = "yzl-staff-db")
public interface StaffFamilyFeginService {


    @ApiOperation(value = "查询员工家庭信息",notes = "查询员工家庭信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffFamily/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffFamilyListDto> findByStaffNo(@RequestParam("staffNO")  String staffNO);

    @ApiOperation(value = "删除信息",notes = "删除信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffFamily/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")  Integer id,@RequestParam("updator") String updator);

    @ApiOperation(value = "添加信息", notes = "添加信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffFamily/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody  List<StaffFamilyInsertPo> staffFamilyInsertList);

    @ApiOperation(value = "修改信息", notes = "修改信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffFamily/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffFamilyUpdatePo FamilyPo);

    @ApiOperation(value = "保存信息", notes = "保存信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/staffFamily/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffFamilyItemPo staffFamilyPo);
}
