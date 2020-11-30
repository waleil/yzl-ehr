package cn.net.yzl.ehr.fegin;

import cn.net.yzl.common.entity.ResultDto;
import cn.net.yzl.ehr.pojo.StaffPo;
import org.springframework.stereotype.Component;

@Component
public class StaffFeginServiceFallBack implements StaffFeginService {

    @Override
    public ResultDto<String> getByPrimaryKey(int id) {
        return ResultDto.success("StaffFeginServiceFallBack.....");
    }
}
