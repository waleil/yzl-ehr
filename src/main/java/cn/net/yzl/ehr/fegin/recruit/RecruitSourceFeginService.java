package cn.net.yzl.ehr.fegin.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffUpRpListDto;
import cn.net.yzl.ehr.dto.StaffUpTrainListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.staff.dto.recruit.RecruitOperatingRecordDto;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.dto.recruit.RecruitSourceExpenseDto;
import cn.net.yzl.staff.pojo.recruit.*;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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
public interface RecruitSourceFeginService {


    @ApiOperation(value = "查询",notes = "查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/queryRecruit", method = RequestMethod.POST)
    ComResponse<List<RecruitSourceDto>> queryRecruit(@RequestBody RecruitSourceListPo recruitSourceListPo);

    @ApiOperation(value = "查询已启用",notes = "查询已启用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/queryState", method = RequestMethod.GET)
    ComResponse<List<RecruitSourceDto>> queryState();

    @ApiOperation(value = "删除信息",notes = "删除信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @RequestParam("updator") String updator) ;

    @ApiOperation(value = "添加",notes = "添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/addRecruit", method = RequestMethod.POST)
    ComResponse<Integer> addRecruit(@RequestBody RecruitSourceInsertPo insertPo);

    @ApiOperation(value ="修改" ,notes ="修改",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/update",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody RecruitSourceUpdatePo updatePo);


    @ApiOperation(value ="批量修改" ,notes ="批量修改",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/recruit/modity",method = RequestMethod.POST)
    ComResponse<Integer> modity (@RequestBody RecruitSourceUpdateListPo updateListPo);

    @ApiOperation(value ="续费" ,notes ="续费",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/recruit/getRecruitInfo",method = RequestMethod.POST)
    ComResponse<Integer> getRecruitInfo(@RequestBody RecruitSourceUpdatePo updatePo);

    @ApiOperation(value ="分页" ,notes ="分页",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/recruit/queryPage",method = RequestMethod.GET)
    ComResponse<Page<RecruitSourceDto>>queryPage(@RequestBody RecruitSourceListPo recruitSourceListPo);

    @ApiOperation(value ="停用" ,notes ="停用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/updateState",method = RequestMethod.POST)
    ComResponse<Integer> updateState (@RequestBody RecruitSourceUpdateStatePo updatePo);

    @ApiOperation(value = "查询操作记录",notes = "查询操作记录",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/recruit/selectByPrimaryKey", method = RequestMethod.GET)
    ComResponse <List<RecruitOperatingRecordDto>> selectByPrimaryKey(@RequestParam("resourceId") Integer resourceId);



}
