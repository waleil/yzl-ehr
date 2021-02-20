package cn.net.yzl.ehr.controller.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.recruit.RecruitSourceFeginService;
import cn.net.yzl.ehr.service.recruit.RecruitSourceService;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.pojo.recruit.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/recruit")
@Api(value = "招聘渠道", tags = {"人事管理"})
public class RecruitSourceController {

    @Autowired
    private RecruitSourceService recruitSourceService;

    @ApiOperation(value = "招聘渠道—查询招聘渠道",notes = "查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryRecruit", method = RequestMethod.POST)
    ComResponse<List<RecruitSourceDto>> queryRecruit(@RequestBody RecruitSourceListPo recruitSourceListPo){
        return recruitSourceService.queryRecruit(recruitSourceListPo);
    }

    @ApiOperation(value = "招聘渠道—查询已启用招聘渠道",notes = "查询已启用招聘渠道",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryState", method = RequestMethod.GET)
    ComResponse<List<RecruitSourceDto>> queryState(){
        return recruitSourceService.queryState();
    }

    @ApiOperation(value = "招聘渠道—删除招聘渠道",notes = "删除信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @CurrentStaffNo @ApiIgnore String updator) {
        return recruitSourceService .deleteById(id,updator);
    }



    @ApiOperation(value = "招聘渠道—添加招聘渠道",notes = "添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/addRecruit", method = RequestMethod.POST)
    ComResponse<Integer> addRecruit(@RequestBody RecruitSourceInsertPo insertPo, @CurrentStaffNo @ApiIgnore String staffNo){
        return recruitSourceService.addRecruit(insertPo,staffNo);
    }

    @ApiOperation(value ="招聘渠道—修改招聘渠道" ,notes ="修改",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody RecruitSourceUpdatePo updatePo ,@CurrentStaffNo @ApiIgnore String staffNo){
        return recruitSourceService.update(updatePo,staffNo);
    }


    @ApiOperation(value ="招聘渠道—批量修改招聘渠道状态" ,notes ="批量修改",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/modity",method = RequestMethod.POST)
    ComResponse<Integer> modity (@RequestBody RecruitSourceUpdateListPo updateListPo,@ApiIgnore @CurrentStaffNo String staffNo){
        return recruitSourceService.modity(updateListPo,staffNo);
    }

    @ApiOperation(value ="招聘渠道—招聘渠道续费" ,notes ="续费",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getRecruitInfo",method = RequestMethod.POST)
    ComResponse<Integer> getRecruitInfo(@RequestBody RecruitSourceUpdatePo updatePo,@ApiIgnore @CurrentStaffNo String staffNo){
        return recruitSourceService.getRecruitInfo(updatePo,staffNo);
    }

    @ApiOperation(value ="招聘渠道—招聘渠道分页" ,notes ="分页",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    ComResponse<Page<RecruitSourceDto>> queryPage(@RequestBody RecruitSourceListPo recruitSourceListPo) {
        return recruitSourceService.queryPage(recruitSourceListPo);
    }

    @ApiOperation(value ="招聘渠道—修改招聘渠道停用" ,notes ="停用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    ComResponse<Integer> updateState (@RequestBody RecruitSourceUpdateStatePo updatePo , @CurrentStaffNo @ApiIgnore String staffNo){
        return recruitSourceService.updateState(updatePo,staffNo);
    }

}