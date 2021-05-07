package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.appDeviceRecord.AppDeviceRecordFeignService;
import cn.net.yzl.staff.pojo.AppDeviceRecordPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 移动端安装设备记录控制层
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/appDeviceRecord")
@Api(value = "移动端安装-设备记录", tags = {"移动端安装-设备记录"})
public class AppDeviceRecordController {

    @Autowired
    private AppDeviceRecordFeignService appDeviceRecordService;

    @ApiOperation(value = "新增安装记录", notes = "新增安装记录", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/insert")
    public ComResponse<Boolean> insert(@RequestBody AppDeviceRecordPo appDeviceRecordPo, @ApiIgnore @CurrentStaffNo String staffNo) {
        appDeviceRecordPo.setStaffNo(staffNo);
        return appDeviceRecordService.insert(appDeviceRecordPo);
    }
}
