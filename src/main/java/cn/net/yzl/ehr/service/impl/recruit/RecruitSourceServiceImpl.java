package cn.net.yzl.ehr.service.impl.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.recruit.RecruitSourceFeginService;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceInsertPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceListPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceUpdateListPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceUpdatePo;
import cn.net.yzl.ehr.service.recruit.RecruitSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitSourceServiceImpl implements RecruitSourceService {

    @Autowired
    private RecruitSourceFeginService sourceFeginService;


    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result =sourceFeginService.deleteById(id, updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<List<RecruitSourceDto>> queryRecruit(RecruitSourceListPo recruitSourceListPo) {
        ComResponse<List<RecruitSourceDto>> result = sourceFeginService.queryRecruit(recruitSourceListPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;

    }

    @Override
    public ComResponse<List<RecruitSourceDto>> queryState() {
        ComResponse<List<RecruitSourceDto>> result = sourceFeginService.queryState();
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> addRecruit(RecruitSourceInsertPo insertPo,String staffNo) {
        insertPo.setCreator(staffNo);
        ComResponse<Integer> result = sourceFeginService.addRecruit(insertPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()>0){
            return ComResponse.success();
        }
        return result;

    }

    @Override
    public ComResponse<Integer> modity(RecruitSourceUpdateListPo updateListPo) {
        ComResponse<Integer> result =sourceFeginService.modity(updateListPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;

    }


    @Override
    public ComResponse<Integer> update(RecruitSourceUpdatePo updatePo,String staffNo) {
        updatePo.setUpdator(staffNo);
        ComResponse<Integer> result = sourceFeginService.update(updatePo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;

    }

    @Override
    public ComResponse<Integer> getRecruitInfo(RecruitSourceUpdatePo updatePo,String staffNo) {
        updatePo.setUpdator(staffNo);
        ComResponse<Integer> result = sourceFeginService.getRecruitInfo(updatePo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Page<RecruitSourceDto>> queryPage(RecruitSourceListPo recruitSourceListPo) {
        return sourceFeginService.queryPage(recruitSourceListPo);
    }
}
