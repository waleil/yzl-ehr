package cn.net.yzl.ehr.controller.operation;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.operation.OperationFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.staff.dto.OperationDto;
import cn.net.yzl.staff.vo.OperationPageVo;
import cn.net.yzl.staff.vo.OperationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * cn.net.yzl.ehr.controller.operation
 * 2021/2/5 15:17
 *
 * @author yangxiaopeng
 */
@RestController
@RequestMapping("/operator")
@Api(value = "操作日志", tags = {"操作日志"})
@Slf4j
public class OperationController  {
    @Autowired
    private StaffFeginService staffFeginService;
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
    public ComResponse insertOperation(@RequestBody OperationVo operationVo,HttpServletRequest request){
        String ip = null;
        try {
            ip = getIp(request);
            operationVo.setMacAddr(ip);
            operationVo.setUserCode(request.getHeader("userId"));
            log.info("ip:{},userId:{}",ip,request.getHeader("userId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationFeginService.insertOperation(operationVo);
    }


    @ApiOperation(value = "获取IP接口", notes = "获取IP接口")
    @PostMapping("/getIpAddress")
    public ComResponse getIpAddress(HttpServletRequest request){
        String ip = null;
        try {
           ip = getIp(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ComResponse.success("成功"+ ip);

    }

    /**
     * 获取ip的方法
     * @param request
     * @return
     * @throws Exception
     */
    public String getIp(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        ip = request.getHeader("Proxy-Client-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        ip = request.getRemoteAddr();
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
