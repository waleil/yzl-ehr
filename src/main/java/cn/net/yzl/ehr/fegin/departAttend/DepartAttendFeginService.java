package cn.net.yzl.ehr.fegin.departAttend;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendDto;
import cn.net.yzl.ehr.dto.SysAttendFalsePunishDto;
import cn.net.yzl.ehr.vo.DepartAttendInsertAllVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface DepartAttendFeginService {

    @RequestMapping(value = "departAttendFalse/getByDepartAttendFalseId", method = RequestMethod.GET)
    ComResponse<DepartAttendDto> getByDepartAttendFalseId(@RequestParam("departId") Integer departId, @RequestParam(value = "isEdit", required = false) Integer isEdit);

    @PostMapping("departAttendFalse/insertUpdateDelDepartAttendFalse")
    public ComResponse insertUpdateDelDepartAttendFalse(@RequestBody @Validated DepartAttendInsertAllVo departAttendInsertAllVo);

    @ApiOperation(value = "获取假勤类型和惩罚规则列表", notes = "获取假勤类型和惩罚规则列表")
    @GetMapping("departAttendFalse/getSysAttendFalse")
    public ComResponse<SysAttendFalsePunishDto> getSysAttendFalse();


}
