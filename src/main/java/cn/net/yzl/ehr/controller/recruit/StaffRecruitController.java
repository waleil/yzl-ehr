package cn.net.yzl.ehr.controller.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.StaffRecruitService;
import cn.net.yzl.ehr.util.ValidList;
import cn.net.yzl.staff.dto.recruit.StaffRecruitDto;
import cn.net.yzl.staff.pojo.recruit.RecruitedTaskPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitSelectPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitUpdatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/staffRecruit")
@Api(value = "待招任务", tags = {"人事管理"})
public class StaffRecruitController {


    @Autowired
    private StaffRecruitService staffRecruitService;

    @ApiOperation(value = "待招任务-新增招聘申请",notes = "待招任务-新增招聘申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addStaffRecruitApply", method = RequestMethod.POST)
    public ComResponse<Integer> addStaffRecruitApply(@RequestBody @Validated StaffRecruitPo staffRecruitPo,@CurrentStaffNo @ApiIgnore String staffNo) {
        staffRecruitPo.setCreator(staffNo);
        return staffRecruitService.addStaffRecruitApply(staffRecruitPo);
    }

    @ApiOperation(value = "待招任务-更新招聘申请",notes = "待招任务-更新招聘申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStaffRecruitApply", method = RequestMethod.POST)
    public ComResponse<Integer> updateStaffRecruitApply(@RequestBody @Validated StaffRecruitUpdatePo staffRecruitPo,@CurrentStaffNo @ApiIgnore String staffNo) {
        staffRecruitPo.setUpdator(staffNo);
        return staffRecruitService.updateStaffRecruitApply(staffRecruitPo);
    }

    @ApiOperation(value = "待招任务-查询招聘任务列表",notes = "待招任务-查询招聘任务列表",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getWithTaskByPo", method = RequestMethod.POST)
    public ComResponse<Page<StaffRecruitDto>> getWithTaskByPo(@RequestBody @Validated StaffRecruitSelectPo staffRecruitSelectPo) {
        return staffRecruitService.getWithTaskByPo(staffRecruitSelectPo);
    }

    @ApiOperation(value = "待招任务-查询单个招聘任务详情",notes = "待招任务-查询单个招聘任务详情",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ComResponse<StaffRecruitDto> getById(@RequestParam("id") @NotNull @Min(0) Integer id) {
        return staffRecruitService.getById(id);
    }

    @ApiOperation(value = "待招任务-设置简历跟进时长",notes = "待招任务-设置简历跟进时长",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateResumeFollowTime", method = RequestMethod.GET)
    public ComResponse<Integer> updateResumeFollowTime(@RequestParam("num") @NotNull @Min(0) Integer num,@CurrentStaffNo @ApiIgnore String staffNo) {
        return staffRecruitService.updateResumeFollowTime(num,staffNo);
    }

    @ApiOperation(value = "待招任务-批量分配招聘任务",notes = "待招任务-批量分配招聘任务",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/batchDistributeTask", method = RequestMethod.POST)
    public ComResponse<Integer> batchDistributeTask(@RequestBody @Validated ValidList<RecruitedTaskPo> recruitedTaskPos, @CurrentStaffNo @ApiIgnore String staffNo) {
        recruitedTaskPos.forEach(x->{
            x.setCreator(staffNo);
        });
        return staffRecruitService.batchDistributeTask(recruitedTaskPos);
    }
}
