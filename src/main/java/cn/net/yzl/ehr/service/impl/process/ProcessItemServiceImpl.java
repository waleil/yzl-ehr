package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.ProcessItemFeignService;
import cn.net.yzl.ehr.service.process.ProcessItemService;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import cn.net.yzl.staff.vo.process.ProcessTypeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public ComResponse<Integer> insertProcessType(ProcessTypeVo processTypeVo, String staffNo) {
        processTypeVo.setCreator(staffNo);
        return processItemFeignService.insertProcessType(processTypeVo);
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
        /*String path = null;
        if(file != null){
            String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            if(!"png".equals(fileType) && !"jpg".equals(fileType)){
                throw new BaseParamsException(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),"?????????png??????jpg???????????????!");
            }
        }else{
            throw new BaseParamsException(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),"????????????????????????!");
        }
        try {
            path = client.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("??????????????????????????????");
            throw new BaseParamsException(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),"??????????????????????????????!");
        }
        processItemVo.setIcon(filePrefix+"/"+path);*/
        processItemVo.setCreator(staffNo);
        return processItemFeignService.insertProcessItem(processItemVo);
    }

    @Override
    public ComResponse<Integer> updateProcessItem(ProcessItemVo processItemVo, String staffNo) {
        /*String path = null;
        if(file != null){
            String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            if(!"png".equals(fileType) && !"jpg".equals(fileType)){
                throw new BaseParamsException(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),"?????????png??????jpg???????????????!");
            }
            try {
                path = client.uploadFile(file);
            } catch (IOException e) {
                e.printStackTrace();
                logger.info("??????????????????????????????");
                throw new BaseParamsException(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),"??????????????????????????????!");
            }
            processItemVo.setIcon(filePrefix+"/"+path);
        }*/
        processItemVo.setUpdator(staffNo);
        return processItemFeignService.updateProcessItem(processItemVo);
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
    public ComResponse<Integer> enableProcessItem(Integer id, String staffNo) {
        return processItemFeignService.enableProcessItem(id,staffNo);
    }

    @Override
    public ComResponse<List<ProcessItemDto>> selectProcessItem(Integer id) {
        return processItemFeignService.selectProcessItem(id);
    }

    @Override
    public ComResponse<List<ProcessItemDto>> selectProcessItemAll() {
        return processItemFeignService.selectProcessItemAll();
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

    @Override
    public ComResponse<ProcessItemDto> selectProcessByItemCode(String code) {
        return processItemFeignService.selectProcessByItemCode(code);
    }

    @Override
    public ComResponse<Object> selectProcessByItemIdAndUser(Integer processItemId, String staffNo) {
        return processItemFeignService.selectProcessByItemIdAndUser(processItemId,staffNo);
    }
}
