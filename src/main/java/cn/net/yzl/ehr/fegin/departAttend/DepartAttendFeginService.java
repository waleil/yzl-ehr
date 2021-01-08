package cn.net.yzl.ehr.fegin.departAttend;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendDto;
import cn.net.yzl.ehr.dto.DepartAttendFtDto;
import cn.net.yzl.ehr.dto.SysAttendFalsePunishDto;
import cn.net.yzl.ehr.pojo.DepartAttendFtPo;
import cn.net.yzl.ehr.vo.DepartAttendAllVo;
import cn.net.yzl.ehr.vo.DepartAttendInsertAllVo;
import cn.net.yzl.ehr.vo.DepartAttendVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "staff",url = "${fegin.db.url}")
@Repository
public interface DepartAttendFeginService {

    @RequestMapping(value = "departAttendFalse/getByDepartAttendFalseId", method = RequestMethod.GET)
    ComResponse<DepartAttendDto> getByDepartAttendFalseId(@RequestParam("departId") Integer departId, @RequestParam(value = "isEdit",required = false) Integer isEdit);

    @PostMapping("departAttendFalse/insertUpdateDelDepartAttendFalse")
    public ComResponse insertUpdateDelDepartAttendFalse(@RequestBody @Validated DepartAttendInsertAllVo departAttendInsertAllVo);

    @ApiOperation(value = "获取假勤类型和惩罚规则列表", notes = "获取假勤类型和惩罚规则列表")
    @GetMapping("departAttendFalse/getSysAttendFalse")
    public ComResponse<SysAttendFalsePunishDto> getSysAttendFalse();


}
