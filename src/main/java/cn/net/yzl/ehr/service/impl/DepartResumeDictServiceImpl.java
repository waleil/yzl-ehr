package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartResumeDictDto;
import cn.net.yzl.ehr.fegin.departResume.DepartResumeDictFeignService;
import cn.net.yzl.ehr.pojo.DepartResumeDictListPo;
import cn.net.yzl.ehr.service.DepartResumeDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartResumeDictServiceImpl implements DepartResumeDictService {
    @Autowired
    private DepartResumeDictFeignService departResumeDictFeignService;

    @Override
    public ComResponse<List<DepartResumeDictDto>> getDictList() {
        ComResponse<List<DepartResumeDictDto>> dictList = departResumeDictFeignService.getDictList();
        if(dictList==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return dictList;
    }

    @Override
    public ComResponse<DepartResumeDictDto> getDictById(Integer id) {
        ComResponse<DepartResumeDictDto> dictById = departResumeDictFeignService.getDictById(id);
        if(dictById==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return dictById;
    }

    @Override
    public ComResponse<List<DepartResumeDictDto>> selectListByName(String name) {
        ComResponse<List<DepartResumeDictDto>> listComResponse = departResumeDictFeignService.selectListByName(name);
        if(listComResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return listComResponse;
    }


    @Override
    public ComResponse<Integer> saveUpdate(DepartResumeDictListPo listPo,String staffNo) {
        if(listPo!=null){
            if(listPo.getInsertList()!=null && listPo.getInsertList().size()>0){
                listPo.getInsertList().forEach(x->{
                    x.setCreator(staffNo);
                });
            }
            if(listPo.getDeleteList()!=null && listPo.getDeleteList().size()>0){
                listPo.getDeleteList().forEach(x->{
                    x.setUpdator(staffNo);
                });
            }
            if(listPo.getUpdateList()!=null && listPo.getUpdateList().size()>0){
                listPo.getUpdateList().forEach(x->{
                    x.setUpdator(staffNo);
                });
            }
        }

        ComResponse<Integer> integerComResponse = departResumeDictFeignService.saveUpdate(listPo);
        if(integerComResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return integerComResponse;
    }
}
