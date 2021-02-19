package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.recruit.StaffRecruitDto;
import cn.net.yzl.staff.pojo.recruit.RecruitedTaskPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitSelectPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitUpdatePo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StaffRecruitService {

    public ComResponse<Integer> addStaffRecruitApply(StaffRecruitPo staffRecruitPo) ;

    public ComResponse<Integer> updateStaffRecruitApply(StaffRecruitUpdatePo staffRecruitPo) ;

    public ComResponse<Page<StaffRecruitDto>> getWithTaskByPo(StaffRecruitSelectPo staffRecruitSelectPo) ;

    public ComResponse<StaffRecruitDto> getById(Integer id) ;

    public ComResponse<Integer> updateResumeFollowTime(Integer num, String staffNo) ;

    public ComResponse<Integer> batchDistributeTask(List<RecruitedTaskPo> recruitedTaskPos ) ;
}
