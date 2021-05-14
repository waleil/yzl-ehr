package cn.net.yzl.ehr.fegin.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.deduct.IncreaseRecordDto;
import cn.net.yzl.staff.pojo.deduct.IncreaseRecordListPo;
import cn.net.yzl.staff.pojo.deduct.IncreaseRecordPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface IncreaseRecordFeginService {

    @ApiOperation(value = "查询奖金列表信息", notes = "查询奖金列表信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/getList", method = RequestMethod.POST)
    ComResponse<Page<IncreaseRecordDto>> getList(@RequestBody(required = false) IncreaseRecordListPo increaseRecordListPo);


    @ApiOperation(value = "查询奖金详情信息", notes = "查询奖金详情信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/selectOne", method = RequestMethod.GET)
    ComResponse<IncreaseRecordDto> selectOne(@RequestParam("id") Integer id);

    @ApiOperation(value = "添加奖金记录", notes = "添加奖金记录", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/insertIncreaseRecord", method = RequestMethod.POST)
    ComResponse<Integer> insertIncreaseRecord(@RequestBody IncreaseRecordPo increaseRecordPo);

    @ApiOperation(value = "取消奖金", notes = "取消奖金", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/updateStateById", method = RequestMethod.GET)
    ComResponse<Integer> updateStateById(@RequestParam("id") Integer id);

    @ApiOperation(value = "删除信息", notes = "删除信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/deleteById", method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @RequestParam("updator") String staffNo);

    @ApiOperation(value = "启用", notes = "启用", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/updateState", method = RequestMethod.POST)
    ComResponse<Integer> updateState(@RequestBody IncreaseRecordPo increaseRecordPo);

    @ApiOperation(value = "修改执行状态", notes = "修改执行状态", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/updateExecuteState", method = RequestMethod.POST)
    ComResponse<Integer> updateExecuteState(@RequestBody IncreaseRecordPo increaseRecordPo);

    @ApiOperation(value = "根据工号和时间查询奖金列表信息", notes = "根据工号和时间查询奖金列表信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/increaseRecord/queryList", method = RequestMethod.POST)
    ComResponse<List<IncreaseRecordDto>> queryList(@RequestParam("staffNo") String staffNo, @RequestParam("increaseTime") String increaseTime);


}


