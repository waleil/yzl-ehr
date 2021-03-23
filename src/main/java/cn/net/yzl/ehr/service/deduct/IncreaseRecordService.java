package cn.net.yzl.ehr.service.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.dto.deduct.IncreaseRecordDto;
import cn.net.yzl.staff.pojo.deduct.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncreaseRecordService {
    //查询奖金列表信息
    ComResponse<Page<IncreaseRecordDto>> getList(IncreaseRecordListPo increaseRecordListPo);

    //查询奖金详情
    ComResponse<IncreaseRecordDto> selectone(Integer id);

    //添加奖金记录
    ComResponse<Integer> insertIncreaseRecord(IncreaseRecordPo increaseRecordPo);

    //取消奖金
    ComResponse<Integer> updateStateById(Integer id);

    //启用
    ComResponse<Integer> updateIncreaseStateById(Integer id);
    //删除
    ComResponse<Integer> deleteById(Integer id,String staffNo);

    //修改执行状态
    ComResponse<Integer>  updateExecuteState(IncreaseRecordPo increaseRecordPo);

    //根据员工号和发放时间查询消息列表
    ComResponse<List<IncreaseRecordDto>> queryList(@Param("staffNo") String staffNo, @Param("increaseTime")String increaseTime);
}
