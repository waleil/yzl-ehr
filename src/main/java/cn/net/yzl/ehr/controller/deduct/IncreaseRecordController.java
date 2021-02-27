package cn.net.yzl.ehr.controller.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.deduct.DeductReocrdService;
import cn.net.yzl.ehr.service.deduct.IncreaseRecordService;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.dto.deduct.IncreaseRecordDto;
import cn.net.yzl.staff.pojo.deduct.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/increaseRecord")
@Api(value = "奖金记录", tags = {"奖惩管理"})
public class IncreaseRecordController {
    @Autowired
    private IncreaseRecordService increaseRecordService;

    @ApiOperation(value = "查询奖金列表信息", notes = "查询奖金列表信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    ComResponse<List<IncreaseRecordDto>> getList(@RequestBody(required = false) IncreaseRecordListPo increaseRecordListPo) {
        return increaseRecordService.getList(increaseRecordListPo);
    }

    @ApiOperation(value = "查询奖金详情信息", notes = "查询奖金详情信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/selectone", method = RequestMethod.POST)
    ComResponse<IncreaseRecordDto> selectone(@RequestParam("id")Integer id) {
        return increaseRecordService.selectone(id);
    }

    @ApiOperation(value = "添加奖金记录", notes = "添加奖金记录",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insertIncreaseRecord", method = RequestMethod.POST)
    ComResponse<Integer> insertIncreaseRecord(@RequestBody IncreaseRecordPo increaseRecordPo){
        return increaseRecordService.insertIncreaseRecord(increaseRecordPo);
    }

    @ApiOperation(value = "取消奖金", notes = "取消奖金",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateStateById", method = RequestMethod.GET)
    ComResponse<Integer> updateStateById(@RequestParam("id")Integer id){
        return increaseRecordService.updateStateById(id);
    }

    @ApiOperation(value = "删除信息",notes = "删除信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")Integer id, @CurrentStaffNo @ApiIgnore String staffNo) {
        return increaseRecordService .deleteById(id,staffNo);
    }

    @ApiOperation(value = "启用", notes = "启用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateIncreaseStateById", method = RequestMethod.POST)
    ComResponse<Integer> updateIncreaseStateById(@RequestParam("id")Integer id){
        return increaseRecordService.updateStateById(id);
    }

    @ApiOperation(value = "修改执行状态", notes = "修改执行状态",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateExecuteState", method = RequestMethod.POST)
    ComResponse<Integer> updateExecuteState(@RequestBody IncreaseRecordPo increaseRecordPo){
        return increaseRecordService.updateExecuteState(increaseRecordPo);
    }


}
