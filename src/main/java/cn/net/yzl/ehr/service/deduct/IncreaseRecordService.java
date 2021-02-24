package cn.net.yzl.ehr.service.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.dto.deduct.IncreaseRecordDto;
import cn.net.yzl.staff.pojo.deduct.*;

import java.util.List;

public interface IncreaseRecordService {
    //查询奖金列表信息
    ComResponse<List<IncreaseRecordDto>> getList(IncreaseRecordListPo increaseRecordListPo);

    //查询奖金详情
    ComResponse<IncreaseRecordDto> selectone(Integer id);

    //添加奖金记录
    ComResponse<Integer> insertIncreaseRecord(IncreaseRecordInsertPo increaseRecordInsertPo);

    //取消奖金
    ComResponse<Integer> updateStateById(Integer id);

    //启用
    ComResponse<Integer> updateIncreaseStateById(Integer id);
    //删除
    ComResponse<Integer> deleteById(Integer id, String updator);
}
