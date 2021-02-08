package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.StaffWorkInsertListPo;
import cn.net.yzl.ehr.pojo.StaffWorkItemPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdateListPo;
import cn.net.yzl.ehr.pojo.StaffWorkUpdatePo;
import cn.net.yzl.staff.dto.PostDto;
import cn.net.yzl.staff.dto.StaffReferralComDto;
import cn.net.yzl.staff.pojo.StaffReferralComInsertPo;
import cn.net.yzl.staff.pojo.StaffReferralComUpdatePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffReferralComService {

   ComResponse<List<StaffReferralComDto>> getlist(@Param("departId") Integer departId, @Param("postId") Integer postId);

   ComResponse<Integer> deleteById(Integer id);

   ComResponse<Integer> insert(StaffReferralComInsertPo staffReferralComInsertPo);

   ComResponse<List<PostDto>> getPost(Integer departId);

   ComResponse<Integer> updateById(StaffReferralComUpdatePo staffReferralComUpdatePo);

   ComResponse<StaffReferralComDto> selectDetail(Integer id);

}
