package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.process.ProcessItemFeignService;
import cn.net.yzl.ehr.service.process.ProcessItemService;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.exception.BaseParamsException;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProcessItemServiceImpl implements ProcessItemService {

    private static final Logger logger = LoggerFactory.getLogger(ProcessItemServiceImpl.class);

    @Value("${file.prefix}")
    private String filePrefix;

    @Autowired
    private FastDFSClientWrapper client;

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
    public ComResponse<Integer> insertProcessItem(MultipartFile file,ProcessItemVo processItemVo, String staffNo) {
        String path = null;
        try {
            path = client.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("审批项目图标添加失败");
            throw new BaseParamsException(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),"审批项目图标添加失败!");
        }
        processItemVo.setIcon(filePrefix+"/"+path);
        return processItemFeignService.insertProcessItem(processItemVo,staffNo);
    }

    @Override
    public ComResponse<Integer> updateProcessItem(MultipartFile file,ProcessItemVo processItemVo, String staffNo) {
        String path = null;
        try {
            path = client.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("审批项目图标修改失败");
            throw new BaseParamsException(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),"审批项目图标修改失败!");
        }
        processItemVo.setIcon(filePrefix+"/"+path);
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
    public ComResponse<ProcessItemDto> selectProcessItemDetail(Integer id) {
        return processItemFeignService.selectProcessItemDetail(id);
    }

    @Override
    public ComResponse<List<ProcessTypeDto>> processItemDisplay(String staffNo) {
        return processItemFeignService.processItemDisplay(staffNo);
    }

    @Override
    public ComResponse<List<ProcessTypeDto>> processItemDisplayByUser(String staffNo) {
        return processItemFeignService.processItemDisplayByUser(staffNo);
    }
}