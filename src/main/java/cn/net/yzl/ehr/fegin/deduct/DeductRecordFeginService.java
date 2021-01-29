package cn.net.yzl.ehr.fegin.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.pojo.deduct.DeductRecordInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductRecordListPo;
import cn.net.yzl.staff.pojo.deduct.DeductRecordUpdatePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
public interface DeductRecordFeginService {

    @ApiOperation(value = "查询扣款列表信息", notes = "查询扣款列表信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/getList", method = RequestMethod.POST)
    ComResponse<List<DeductRecordDto>> getList(@RequestBody(required = false) DeductRecordListPo deductRecordListPo);


    @ApiOperation(value = "停止扣款", notes = "停止扣款",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/updateStateById", method = RequestMethod.POST)
    ComResponse<Integer> updateStateById(@RequestBody DeductRecordUpdatePo deductRecordUpdatePo);

    @ApiOperation(value = "新建扣款申请", notes = "新建扣款申请",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deductRecord/insertDeductRecord", method = RequestMethod.POST)
    ComResponse<Integer> insertDeductRecord(@RequestBody DeductRecordInsertPo deductRecordInsertPo);
}