package cn.net.yzl.ehr.controller.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.pojo.deduct.DeductItemInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdatePo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdateStatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/deduct")
@Api(value = "扣款类型", tags = {"奖惩管理"})
public class DeductItemController {
    @Autowired
    private DeductItemService deductItemService;

    @ApiOperation(value = "查询扣款类型",notes = "查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    ComResponse<List<DeductItemDto>> queryAll(){
        return deductItemService.queryAll();
    }

    @ApiOperation(value = "添加扣款类型",notes = "添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody @Validated DeductItemInsertPo insertPo,@ApiIgnore @CurrentStaffNo String staffNo){
        return deductItemService.insert(insertPo,staffNo);
    }

    @ApiOperation(value ="修改扣款类型" ,notes ="修改",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    @RequestMapping(value = "/updateByState",method = RequestMethod.POST)
    ComResponse<Integer> updateByState (@RequestBody @Validated DeductItemUpdateStatePo updatePo, @ApiIgnore @CurrentStaffNo String staffNo){
        return deductItemService.updateByState(updatePo,staffNo);
    }

    @ApiOperation(value = "查询所有",notes = "查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryItem", method = RequestMethod.GET)
    ComResponse<List<DeductItemDto>> queryItem(){
        return deductItemService.queryItem();
    }

    @ApiOperation(value ="编辑扣款类型" ,notes ="编辑扣款类型",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody DeductItemUpdatePo updatePo, @ApiIgnore @CurrentStaffNo String staffNo){
        return deductItemService.update(updatePo,staffNo);
    }

}
