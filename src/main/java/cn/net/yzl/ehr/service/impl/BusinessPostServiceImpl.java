package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.BusinessPostDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelIndicatorsDto;
import cn.net.yzl.ehr.fegin.businessPost.BusinessPostFeginService;
import cn.net.yzl.ehr.service.BusinessPostService;
import cn.net.yzl.ehr.vo.BusinessPostVO;
import cn.net.yzl.ehr.vo.PostLevelIndicatorsVO;
import cn.net.yzl.staff.dto.PostLevelUpRuleDto;
import cn.net.yzl.staff.vo.PostLevelIndicatorsUpDurationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessPostServiceImpl implements BusinessPostService {
    @Autowired
    private BusinessPostFeginService businessPostFeginService;

    @Override
    public ComResponse<Integer> addBussnessAtrrPost(BusinessPostVO businessPostVO) {
        return businessPostFeginService.addBussnessAtrrPost(businessPostVO);
    }

    @Override
    public ComResponse<List<BusinessPostDto>> getBusiPostListByAttr(Integer bussinessAtrrCode) {

        return businessPostFeginService.getBusiPostListByAttr(bussinessAtrrCode);
    }

    @Override
    public ComResponse<List<PostDto>> getPostListByBussinessAttrCode(Integer bussinessAtrrCode) {
        return businessPostFeginService.getPostListByBussinessAttrCode(bussinessAtrrCode);
    }

    @Override
    public ComResponse<PostLevelUpRuleDto> getPostLevelIndicatorsList(Integer postLevelId) {

        return businessPostFeginService.getPostLevelIndicatorsList(postLevelId);
    }

    @Override
    public ComResponse<Integer> delPostIndicators(Integer id) {
        return businessPostFeginService.delPostIndicators(id);
    }

    @Override
    public ComResponse<List<PostLevelIndicatorsDto>> getAllPostIndcatorsList(Integer postLevelId) {

        return businessPostFeginService.getAllPostIndcatorsList(postLevelId);
    }

    @Override
    public ComResponse<Integer> addOrUpdatePostIndicators(List<PostLevelIndicatorsVO> postLevelIndicatorsVOList) {
        return businessPostFeginService.addOrUpdatePostIndicators(postLevelIndicatorsVOList);
    }

    @Override
    public ComResponse<Boolean> addOrUpdateDuration(PostLevelIndicatorsUpDurationVO upDurationVO) {
        return businessPostFeginService.addOrUpdateDuration(upDurationVO);
    }
}
