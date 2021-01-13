package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.pojo.PostLevelPo;
import cn.net.yzl.ehr.pojo.PostLevelUpdatePo;
import cn.net.yzl.ehr.service.PostLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@RequestMapping("/postLevel")
@RestController
@Api(value = "岗位级别接口", tags = {"字典配置"})
public class PostLevelController {


        @Autowired
        private PostLevelService postLevelService;


    @ApiOperation(value = "查询岗位级别信息", notes = "查询岗位级别信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    ComResponse<PostLevelDto> getById(@RequestParam("id") @NotNull @Min(0) Integer id){
        return postLevelService.getById(id);
    }

    @ApiOperation(value = "删除岗位级别", notes = "删除岗位级别", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    ComResponse<Integer> delete(@RequestParam("id") @NotNull @Min(0) Integer id, @CurrentStaffNo @ApiIgnore String staffNo){
        return postLevelService.delete(id,staffNo);
    }

    @ApiOperation(value = "新建岗位级别", notes = "新建岗位级别", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addPostLevel", method = RequestMethod.POST)
    ComResponse<Integer> addPostLevel(@RequestBody @Validated PostLevelPo postLevelPo, @CurrentStaffNo @ApiIgnore String staffNo){
        return postLevelService.addPostLevel(postLevelPo,staffNo);
    }

   /* @ApiOperation(value = "批量新建岗位级别", notes = "批量新建岗位级别", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addBatchPostLevel", method = RequestMethod.POST)
    ComResponse<Integer> addBatchPostLevel(@RequestBody @Validated({InsertVal.class}) List<PostLevelPo> postLevelList){
        return postLevelService.addBatch(postLevelList);
    }*/

    @ApiOperation(value = "编辑岗位级别", notes = "编辑岗位级别", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody @Validated PostLevelUpdatePo postLevel, @CurrentStaffNo @ApiIgnore String staffNo){
        return postLevelService.update(postLevel,staffNo);
    }

    @ApiOperation(value = "查询岗位级别列表", notes = "查询岗位级别列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    ComResponse<List<PostLevelDto>> getList(){
        return postLevelService.getList();
    }

    @ApiOperation(value = "查询岗位的岗位级别列表", notes = "查询岗位的岗位级别列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getListByPostId", method = RequestMethod.GET)
    ComResponse<PostLevelListDto> getListByPostId(@RequestParam("postId") @NotNull @Min(0) Integer postId){
        return postLevelService.getListByPostId(postId);
    }

    @ApiOperation(value = "获取当前岗位级别员工数量", notes = "获取当前岗位级别", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getStaffTotalForPostLevel", method = RequestMethod.GET)
    ComResponse<Integer> getStaffTotalForPostLevel(@RequestParam("postLevelId") @NotNull @Min(0) Integer postLevelId) {
        return postLevelService.getStaffTotalForPostLevel(postLevelId);
    }

}
