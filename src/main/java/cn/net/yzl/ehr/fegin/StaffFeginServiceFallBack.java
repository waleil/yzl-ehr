package cn.net.yzl.ehr.fegin;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.StaffPo;
import org.springframework.stereotype.Component;

@Component
public class StaffFeginServiceFallBack implements StaffFeginService {

    @Override
    public ComResponse<String> getByPrimaryKey(int id) {
        return ComResponse.success("StaffFeginServiceFallBack.....");
    }
}
