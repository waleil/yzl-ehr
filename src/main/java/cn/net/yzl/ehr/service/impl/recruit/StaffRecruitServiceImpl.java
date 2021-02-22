package cn.net.yzl.ehr.service.impl.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.recruit.StaffRecruitFeginService;
import cn.net.yzl.ehr.service.StaffRecruitService;
import cn.net.yzl.staff.dto.recruit.StaffRecruitDto;
import cn.net.yzl.staff.pojo.recruit.RecruitedTaskPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitSelectPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRecruitServiceImpl implements StaffRecruitService {


    @Autowired
    private StaffRecruitFeginService staffRecruitFeginService;

    @Override
    public ComResponse<Integer> addStaffRecruitApply(StaffRecruitPo staffRecruitPo) {
        return staffRecruitFeginService.addStaffRecruitApply(staffRecruitPo);
    }

    @Override
    public ComResponse<Integer> updateStaffRecruitApply(StaffRecruitUpdatePo staffRecruitPo) {
        return staffRecruitFeginService.updateStaffRecruitApply(staffRecruitPo);
    }

    @Override
    public ComResponse<Page<StaffRecruitDto>> getWithTaskByPo(StaffRecruitSelectPo staffRecruitSelectPo) {
        return staffRecruitFeginService.getWithTaskByPo(staffRecruitSelectPo);
    }

    @Override
    public ComResponse<StaffRecruitDto> getById(Integer id) {
        return staffRecruitFeginService.getById(id);
    }

    @Override
    public ComResponse<Integer> updateResumeFollowTime(Integer num, String staffNo) {
        return staffRecruitFeginService.updateResumeFollowTime(num,staffNo);
    }

    @Override
    public ComResponse<Integer> batchDistributeTask(List<RecruitedTaskPo> recruitedTaskPos) {
        return staffRecruitFeginService.batchDistributeTask(recruitedTaskPos);
    }
}
