package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import cn.net.yzl.staff.vo.process.ProcessTypeVo;

import java.util.List;

public interface ProcessItemService {
    ComResponse<Integer> insertProcessType(ProcessTypeVo processTypeVo, String staffNo);

    ComResponse<List<SysDictDataDto>> queryProcessTypeAll();

    ComResponse<Integer> deleteProcessType(Integer dictCode);

    ComResponse<Integer> insertProcessItem(ProcessItemVo processItemVo, String staffNo);

    ComResponse<Integer> updateProcessItem(ProcessItemVo processItemVo, String staffNo);

    ComResponse<Integer> deleteProcessItem(Integer id, String staffNo);

    ComResponse<Integer> disableProcessItem(Integer id, String staffNo);

    ComResponse<Integer> enableProcessItem(Integer id, String staffNo);

    //根据审批类型id查询
    ComResponse<List<ProcessItemDto>> selectProcessItem(Integer id);

    //查询审批项目
    ComResponse<List<ProcessItemDto>> selectProcessItemAll();

    //根据审批项目id查询
    ComResponse<ProcessItemDto> selectProcessItemDetail(Integer id);

    ComResponse<List<ProcessTypeDto>> processItemDisplay(String staffNo);

    ComResponse<List<ProcessTypeDto>> processItemDisplayByUser(String staffNo);

    //根据流程项目code查询
    ComResponse<ProcessItemDto> selectProcessByItemCode(String code);

    //根据流程项目id和当前发起的用户查询是否可以发起流程(true:可以发起，false:不可以发起)
    ComResponse<Boolean> selectProcessByItemIdAndUser(Integer processItemId, String staffNo);

}
