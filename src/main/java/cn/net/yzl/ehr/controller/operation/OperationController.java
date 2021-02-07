package cn.net.yzl.ehr.controller.operation;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.operation.OperationFeginService;
import cn.net.yzl.staff.dto.OperationDto;
import cn.net.yzl.staff.vo.OperationPageVo;
import cn.net.yzl.staff.vo.OperationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cn.net.yzl.ehr.controller.operation
 * 2021/2/5 15:17
 *
 * @author yangxiaopeng
 */
@RestController
@RequestMapping("/operator")
@Api(value = "操作日志", tags = {"操作日志"})
public class OperationController  {
    @Autowired
    private OperationFeginService operationFeginService;
    @ApiOperation(value = "分页查询操作日志", notes = "分页查询操作日志")
    @PostMapping("/selectOperationPageList")
    public ComResponse<Page<OperationDto>> selectOperationPageList(@RequestBody OperationPageVo operationPageVo) {
        return operationFeginService.selectOperationPageList(operationPageVo);
    }

    @ApiOperation(value = "分页查询操作日志详情", notes = "分页查询操作日志详情")
    @PostMapping("/selectOperationItemPageList")
    public ComResponse<Page<OperationDto>> selectOperationItemPageList(@RequestBody OperationPageVo operationPageVo) {
        return operationFeginService.selectOperationItemPageList(operationPageVo);
    }

    @ApiOperation(value = "外部新增接口", notes = "外部新增接口")
    @PostMapping("/insertOperation")
    public ComResponse insertOperation(@RequestBody OperationVo operationVo){
        return operationFeginService.insertOperation(operationVo);
    }
}
