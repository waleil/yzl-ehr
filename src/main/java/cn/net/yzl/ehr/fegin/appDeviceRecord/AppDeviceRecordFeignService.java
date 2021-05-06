package cn.net.yzl.ehr.fegin.appDeviceRecord;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.pojo.AppDeviceRecordPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 移动端安装设备记录服务
 *
 * @author biebaojie
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface AppDeviceRecordFeignService {

    /**
     * 新增移动端安装设备记录
     *
     * @param appDeviceRecordPo 移动端安装设备记录
     * @return 新增结果
     */
    @PostMapping("/appDeviceRecord/insert")
    ComResponse<Boolean> insert(@RequestBody AppDeviceRecordPo appDeviceRecordPo);
}
