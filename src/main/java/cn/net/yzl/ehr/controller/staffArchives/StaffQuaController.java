package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.dto.StaffQuaListDto;
import cn.net.yzl.ehr.pojo.StaffEduItemPo;
import cn.net.yzl.ehr.pojo.StaffQuaInsertPo;
import cn.net.yzl.ehr.pojo.StaffQuaItemPo;
import cn.net.yzl.ehr.pojo.StaffQuaUpdatePo;
import cn.net.yzl.ehr.service.StaffQuaService;
import cn.net.yzl.staff.dto.StaffQuaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/staff/staffQua")
@Api(value = "资质证书", tags = {"员工档案"})
public class StaffQuaController {
    @Autowired
    private StaffQuaService   staffQuaService;

    @ApiOperation(value = "资质证书—查询员工资质证书",notes = "查询员工资质证书",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "StaffNo", value = "员工工号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffQuaDto> findByStaffNo(@RequestParam("StaffNo") @NotBlank String StaffNo) {
        return staffQuaService.findByStaffNo(StaffNo);
    }


    /*@ApiOperation(value = "资质证书—删除员工资质证书",notes = "删除员工资质证书",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工教育经历编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") @Min(1) Integer id, @ApiIgnore @CurrentStaffNo String staffNo) {
        return staffQuaService.deleteById(id,staffNo);
    }

     */


    @ApiOperation(value = "资质证书—编辑员工资质证书", notes = "编辑员工资质证书", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody @Validated StaffQuaInsertPo insertList) {
        return staffQuaService.insert(insertList);
    }


 /*   @ApiOperation(value = "资质证书—修改员工资质证书", notes = "添加员工资质证书", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upaDteQua",method = RequestMethod.POST)
    ComResponse<Integer> UpDate (@RequestBody @Validated StaffQuaUpdatePo updatePo ){
        return staffQuaService.updateQua(updatePo);
    }*/

  /*  @ApiOperation(value = "资质证书—保存员工资质证书", notes = "保存员工资质证书", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody @Validated StaffQuaItemPo itemPo , @ApiIgnore @CurrentStaffNo String staffNo){
        itemPo.getInsertList().forEach(x->{
            x.setCreator(staffNo);
        });
        itemPo.getUpdateList().forEach(x->{
            x.setUpdator(staffNo);
        });
        itemPo.getDeleteList().forEach(x->{
            x.setUpdator(staffNo);
        });
        return staffQuaService.saveUpDate(itemPo);
    }*/



}
