package cn.net.yzl.ehr.fegin.operation;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.OperationDto;
import cn.net.yzl.staff.vo.OperationPageVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * cn.net.yzl.ehr.fegin.operation
 * 2021/2/5 15:14
 *
 * @author yangxiaopeng
 */
//@FeignClient(name = "yzl-staff-api")
@FeignClient(value = "operation",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
@Repository
public interface OperationFeginService {
    @ApiOperation(value = "分页查询操作日志", notes = "分页查询操作日志")
    @PostMapping("operation/selectOperationPageList")
    public ComResponse<Page<OperationDto>> selectOperationPageList(@RequestBody OperationPageVo operationPageVo);

    @ApiOperation(value = "分页查询操作日志详情", notes = "分页查询操作日志详情")
    @PostMapping("operation/selectOperationItemPageList")
    public ComResponse<Page<OperationDto>> selectOperationItemPageList(@RequestBody OperationPageVo operationPageVo);

    @ApiOperation(value = "外部新增接口", notes = "外部新增接口")
    @GetMapping("operation/insertOperation")
    public ComResponse insertOperation(@RequestParam(value = "macCode",required = false)String macCode, @RequestParam(value = "actionCode")String actionCode,
                                       @RequestParam(value = "userCode")String userCode, @RequestParam(value = "ip")String ip);
}
