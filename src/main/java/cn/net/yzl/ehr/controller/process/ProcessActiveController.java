package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.processActiveService.FindProcessNodeService;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;

import com.alibaba.nacos.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/processActive")
@Api(tags = "发起流程")
public class ProcessActiveController {
    @Autowired
    private FindProcessNodeService findProcessNodeService;

    @Autowired
    private FastDFSClientWrapper client;

    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "获取流程每个节点信息")
    public ComResponse<List<ProcessNodeDTO>> findProcessInfoList(@RequestParam @NotNull Integer processId,
                                                                 @RequestParam @NotNull @CurrentStaffNo String staffNo) {

        return findProcessNodeService.findProcessInfoList(processId,staffNo);
    }

    @PostMapping("v1/saveProcessLeaveInfo")
    @ApiOperation(value = "保存请假信息")
    public ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid StaffLeaveDTO staffLeaveDTO) {

        return findProcessNodeService.saveProcessLeaveInfo(staffLeaveDTO);
    }

    @PostMapping("v1/upfile")
    @ApiOperation(value = "上传文件信息")
    public String upFile(@RequestParam @Null MultipartFile file) throws IOException {
        String url ="";
        if(StringUtils.isNotBlank(file.getOriginalFilename())){
            url=client.uploadFile(file);
        }

        return url;
    }


}
