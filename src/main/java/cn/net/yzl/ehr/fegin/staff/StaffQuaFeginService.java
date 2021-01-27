package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.dto.StaffQuaListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.staff.dto.StaffQuaDto;
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
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
public interface StaffQuaFeginService {


    @ApiOperation(value = "查询员工资质证书",notes = "查询员工资质证书",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffQua/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffQuaDto> findByStaffNo(@RequestParam("staffNO")  String staffNO);

    @ApiOperation(value = "删除员工资质证书",notes = "删除员工资质证书",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffQua/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")  Integer id,@RequestParam("updator") String updator);

    @ApiOperation(value = "添加员工资质证书", notes = "添加员工资质证书", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffQua/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody  StaffQuaInsertPo insertPo);

    @ApiOperation(value = "修改员工资质证书", notes = "修改员工资质证书", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffQua/upadteQua",method = RequestMethod.POST)
    ComResponse<Integer> updateQua (@RequestBody StaffQuaUpdatePo updatePo);

    @ApiOperation(value = "保存员工资质证书", notes = "保存员工资质证书", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/staffQua/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffQuaItemPo itemPo);
}
