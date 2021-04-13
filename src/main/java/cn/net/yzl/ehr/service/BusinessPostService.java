package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.BusinessPostDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelIndicatorsDto;
import cn.net.yzl.ehr.vo.BusinessPostVO;
import cn.net.yzl.ehr.vo.PostLevelIndicatorsVO;
import cn.net.yzl.staff.dto.PostLevelUpRuleDto;
import cn.net.yzl.staff.vo.PostLevelIndicatorsUpDurationVO;

import java.util.List;

public interface BusinessPostService {
    ComResponse<Integer> addBussnessAtrrPost(BusinessPostVO businessPostVO);

    ComResponse<List<BusinessPostDto>> getBusiPostListByAttr(Integer bussinessAtrrCode);

    ComResponse<List<PostDto>> getPostListByBussinessAttrCode(Integer bussinessAtrrCode);

    ComResponse<List<PostLevelIndicatorsDto>> getPostLevelIndicatorsList(Integer postLevelId);

    ComResponse<Integer> delPostIndicators(Integer id);

    ComResponse<PostLevelUpRuleDto> getAllPostIndcatorsList(Integer postLevelId);

    ComResponse<Integer> addOrUpdatePostIndicators(List<PostLevelIndicatorsVO> postLevelIndicatorsVOList);

    ComResponse<Boolean> addOrUpdateDuration(PostLevelIndicatorsUpDurationVO upDurationVO);
}
