package cn.net.yzl.ehr.fegin.operation;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.OperationDto;
import cn.net.yzl.staff.vo.OperationPageVo;
import cn.net.yzl.staff.vo.OperationVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * cn.net.yzl.ehr.fegin.operation
 * 2021/2/5 15:14
 *
 * @author yangxiaopeng
 */
//@FeignClient(name = "yzl-staff-api")
@FeignClient(value = "operator",url = "${fegin.db.url}")
@Repository
public interface OperationFeginService {
    @ApiOperation(value = "分页查询操作日志", notes = "分页查询操作日志")
    @PostMapping("/selectOperationPageList")
    public ComResponse<Page<OperationDto>> selectOperationPageList(@RequestBody OperationPageVo operationPageVo);

    @ApiOperation(value = "分页查询操作日志详情", notes = "分页查询操作日志详情")
    @PostMapping("/selectOperationItemPageList")
    public ComResponse<Page<OperationDto>> selectOperationItemPageList(@RequestBody OperationPageVo operationPageVo);

    @ApiOperation(value = "外部新增接口", notes = "外部新增接口")
    @PostMapping("/insertOperation")
    public ComResponse insertOperation(@RequestBody OperationVo operationVo);
}
