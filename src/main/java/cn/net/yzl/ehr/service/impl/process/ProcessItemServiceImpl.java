package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.ProcessItemFeignService;
import cn.net.yzl.ehr.service.process.ProcessItemService;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessItemServiceImpl implements ProcessItemService {

    @Autowired
    private ProcessItemFeignService processItemFeignService;


    @Override
    public ComResponse<Integer> insertProcessType(String name, String staffNo) {
        return processItemFeignService.insertProcessType(name,staffNo);
    }

    @Override
    public ComResponse<List<SysDictDataDto>> queryProcessTypeAll() {
        return processItemFeignService.queryProcessTypeAll();
    }

    @Override
    public ComResponse<Integer> deleteProcessType(Integer dictCode) {
        return processItemFeignService.deleteProcessType(dictCode);
    }

    @Override
    public ComResponse<Integer> insertProcessItem(ProcessItemVo processItemVo, String staffNo) {
        return processItemFeignService.insertProcessItem(processItemVo,staffNo);
    }

    @Override
    public ComResponse<Integer> updateProcessItem(ProcessItemVo processItemVo, String staffNo) {
        return processItemFeignService.updateProcessItem(processItemVo,staffNo);
    }

    @Override
    public ComResponse<Integer> deleteProcessItem(Integer id, String staffNo) {
        return processItemFeignService.deleteProcessItem(id,staffNo);
    }

    @Override
    public ComResponse<Integer> disableProcessItem(Integer id, String staffNo) {
        return processItemFeignService.disableProcessItem(id,staffNo);
    }

    @Override
    public ComResponse<List<ProcessItemDto>> selectProcessItem(Integer id) {
        return processItemFeignService.selectProcessItem(id);
    }

    @Override
    public ComResponse<List<ProcessTypeDto>> processItemDisplay(String staffNo) {
        return processItemFeignService.processItemDisplay(staffNo);
    }
}
