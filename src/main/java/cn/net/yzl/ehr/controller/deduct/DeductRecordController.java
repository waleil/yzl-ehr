package cn.net.yzl.ehr.controller.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.ehr.service.deduct.DeductReocrdService;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.pojo.deduct.*;
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
@RequestMapping("/deductRecord")
@Api(value = "扣款记录", tags = {"奖惩管理"})
public class DeductRecordController {
    @Autowired
    private DeductReocrdService deductReocrdService;

    @ApiOperation(value = "查询扣款列表信息", notes = "查询扣款列表信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    ComResponse<List<DeductRecordDto>> getList(@RequestBody(required = false) DeductRecordListPo deductRecordListPo) {
        return deductReocrdService.getList(deductRecordListPo);
    }


    @ApiOperation(value = "停止扣款", notes = "停止扣款",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateStateById", method = RequestMethod.POST)
    ComResponse<Integer> updateStateById(@RequestBody DeductRecordUpdatePo deductRecordUpdatePo){
        return deductReocrdService.updateStateById(deductRecordUpdatePo);
    }

    @ApiOperation(value = "新建扣款申请", notes = "新建扣款申请",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insertDeductRecord", method = RequestMethod.POST)
    ComResponse<Integer> insertDeductRecord(@RequestBody DeductRecordInsertPo deductRecordInsertPo){
        return deductReocrdService.insertDeductRecord(deductRecordInsertPo);
    }


}
