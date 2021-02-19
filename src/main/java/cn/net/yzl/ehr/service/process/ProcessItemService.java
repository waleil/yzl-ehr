package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProcessItemService {
    ComResponse<Integer> insertProcessType(String name, String staffNo);

    ComResponse<List<SysDictDataDto>> queryProcessTypeAll();

    ComResponse<Integer> deleteProcessType(Integer dictCode);

    ComResponse<Integer> insertProcessItem(MultipartFile file,ProcessItemVo processItemVo, String staffNo);

    ComResponse<Integer> updateProcessItem(MultipartFile file,ProcessItemVo processItemVo, String staffNo);

    ComResponse<Integer> deleteProcessItem(Integer id, String staffNo);

    ComResponse<Integer> disableProcessItem(Integer id, String staffNo);

    //根据审批类型id查询
    ComResponse<List<ProcessItemDto>> selectProcessItem(Integer id);

    //根据审批项目id查询
    ComResponse<ProcessItemDto> selectProcessItemDetail(Integer id);

    ComResponse<List<ProcessTypeDto>> processItemDisplay(String staffNo);

}
