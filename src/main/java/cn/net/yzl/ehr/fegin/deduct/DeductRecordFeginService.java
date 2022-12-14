package cn.net.yzl.ehr.fegin.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.deduct.DeductProcessDTO;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.dto.deduct.DeductStaffInfoDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.pojo.deduct.DeductRecordListPo;
import cn.net.yzl.staff.pojo.deduct.DeductRecordStateUpdatePo;
import cn.net.yzl.staff.pojo.deduct.DeductRecordUpdatePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface DeductRecordFeginService {

    @ApiOperation(value = "查询扣款列表信息", notes = "查询扣款列表信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/getList", method = RequestMethod.POST)
    ComResponse<Page<DeductRecordDto>> getList(@RequestBody(required = false) DeductRecordListPo deductRecordListPo);


    @ApiOperation(value = "停止扣款", notes = "停止扣款", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/updateStateById", method = RequestMethod.POST)
    ComResponse<Integer> updateStateById(@RequestBody DeductRecordUpdatePo deductRecordUpdatePo);

    @ApiOperation(value = "新建扣款申请", notes = "新建扣款申请", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/insertDeductRecord", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> insertDeductRecord(@RequestBody DeductProcessDTO deductProcessDTO);

    @ApiOperation(value = "根据员工工号或姓名查询员工信息", notes = "根据员工工号或姓名查询员工信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/selectstaff", method = RequestMethod.GET)
    ComResponse<DeductStaffInfoDto> selectstaff(@RequestParam("noOrName") String noOrName);

    @ApiOperation(value = "修改执行流程", notes = "修改执行流程", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/updateExecuteState", method = RequestMethod.POST)
    ComResponse<Integer> updateExecuteState(@RequestBody DeductRecordStateUpdatePo deductRecordStateUpdatePo);

    @ApiOperation(value = "查询扣款列表信息", notes = "查询扣款列表信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/queryByNo", method = RequestMethod.GET)
    ComResponse<DeductRecordDto> queryByNo(@RequestParam("appNo") String appNo);

    @ApiOperation(value = "新建停止扣款申请", notes = "新建停止扣款申请", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/insertStopDeductRecord", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> insertStopDeductRecord(@RequestBody DeductProcessDTO deductProcessDTO);

    @ApiOperation(value = "查询流程名称", notes = "查询流程名称", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/queryByName", method = RequestMethod.GET)
    ComResponse<ProcessDto> queryByName(@RequestParam("processId") Integer processId);

    @ApiOperation(value = "查询停止扣款列表详情", notes = "查询停止扣款列表详情", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/queryStopByNo", method = RequestMethod.GET)
    ComResponse<DeductRecordDto> queryStopByNo(@RequestParam("appNo") String appNo);

    @ApiOperation(value = "根据发生时间和员工查询扣款列表信息", notes = "根据发生时间和员工查询扣款列表信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/queryList", method = RequestMethod.GET)
    ComResponse<List<DeductRecordDto>> queryList(@RequestParam("staffNo") String staffNo, @RequestParam("createTime") String createTime);
}
