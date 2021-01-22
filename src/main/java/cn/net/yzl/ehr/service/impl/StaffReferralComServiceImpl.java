package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.staff.StaffReferralComFeginService;
import cn.net.yzl.ehr.service.StaffReferralComService;
import cn.net.yzl.staff.dto.PostDto;
import cn.net.yzl.staff.dto.StaffReferralComDto;
import cn.net.yzl.staff.pojo.StaffReferralComInsertPo;
import cn.net.yzl.staff.pojo.StaffReferralComUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffReferralComServiceImpl implements StaffReferralComService {


    @Autowired
    private StaffReferralComFeginService staffReferralComFeginService;


    @Override
    public ComResponse<List<StaffReferralComDto>> getlist(Integer departId, Integer postId) {
        ComResponse<List<StaffReferralComDto>> comResponse = staffReferralComFeginService.getlist(departId,postId);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && (comResponse.getData().size()<1)){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id) {
        ComResponse<Integer> comResponse = staffReferralComFeginService.deleteById(id);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> insert(StaffReferralComInsertPo staffReferralComInsertPo) {
        ComResponse<Integer> comResponse = staffReferralComFeginService.insert(staffReferralComInsertPo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return comResponse;
    }

    @Override
    public ComResponse<List<PostDto>> getPost(Integer departId) {
        ComResponse<List<PostDto>> comResponse = staffReferralComFeginService.getPost(departId);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && (comResponse.getData().size()<1)){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> updateById(StaffReferralComUpdatePo staffReferralComUpdatePo) {
        ComResponse<Integer> comResponse = staffReferralComFeginService.updateById(staffReferralComUpdatePo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return comResponse;
    }

    @Override
    public ComResponse<StaffReferralComDto> selectDetail(Integer id) {
        ComResponse<StaffReferralComDto> comResponse = staffReferralComFeginService.detail(id);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && (comResponse.getData()==null)){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return comResponse;
    }
}
