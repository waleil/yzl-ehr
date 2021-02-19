package cn.net.yzl.ehr.fegin.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.dto.recruit.StaffRecruitDto;
import cn.net.yzl.staff.pojo.recruit.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
public interface StaffRecruitFeginService {

    @ApiOperation(value = "新增招聘申请",notes = "新增招聘申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/staffRecruit/queryRecruit", method = RequestMethod.POST)
    public ComResponse<Integer> addStaffRecruitApply(@RequestBody StaffRecruitPo staffRecruitPo);

    @ApiOperation(value = "更新招聘申请",notes = "更新招聘申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/staffRecruit/updateStaffRecruitApply", method = RequestMethod.POST)
    public ComResponse<Integer> updateStaffRecruitApply(@RequestBody StaffRecruitUpdatePo staffRecruitPo) ;

    @ApiOperation(value = "查询招聘任务列表",notes = "查询招聘任务列表",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/staffRecruit/getWithTaskByPo", method = RequestMethod.POST)
    public ComResponse<Page<StaffRecruitDto>> getWithTaskByPo(@RequestBody StaffRecruitSelectPo staffRecruitSelectPo);

    @ApiOperation(value = "查询单个招聘任务详情",notes = "查询单个招聘任务详情",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffRecruit/getById", method = RequestMethod.GET)
    public ComResponse<StaffRecruitDto> getById(@RequestParam Integer id) ;

    @ApiOperation(value = "设置简历跟进时长",notes = "设置简历跟进时长",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffRecruit/updateResumeFollowTime", method = RequestMethod.GET)
    public ComResponse<Integer> updateResumeFollowTime(@RequestParam("num") Integer num,@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "批量分配招聘任务",notes = "批量分配招聘任务",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/staffRecruit/batchDistributeTask", method = RequestMethod.POST)
    public ComResponse<Integer> batchDistributeTask(@RequestBody List<RecruitedTaskPo> recruitedTaskPos ) ;



}
