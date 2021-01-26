package cn.net.yzl.ehr.controller.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.pojo.deduct.DeductItemInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deduct")
@Api(value = "扣款类型", tags = {"扣款类型"})
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
    ComResponse<Integer> insert(@RequestBody @Validated DeductItemInsertPo insertPo){
        return deductItemService.insert(insertPo);
    }

    @ApiOperation(value ="修改扣款类型" ,notes ="修改",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    @RequestMapping(value = "/updateByState",method = RequestMethod.POST)
    ComResponse<Integer> updateByState (@RequestBody @Validated DeductItemUpdatePo updatePo){
        return deductItemService.updateByState(updatePo);
    }

}
