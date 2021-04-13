package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.BusinessPostDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelIndicatorsDto;
import cn.net.yzl.ehr.service.BusinessPostService;
import cn.net.yzl.ehr.vo.BusinessPostVO;
import cn.net.yzl.ehr.vo.PostLevelIndicatorsVO;
import cn.net.yzl.staff.vo.PostLevelIndicatorsUpDurationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/businessPost")
@Api(value = "一线管理-岗位级别条件", tags = {"一线管理-岗位级别条件"})
@Validated
public class BusinessPostController {

    @Autowired
    private BusinessPostService businessPostService;

    @ApiOperation(value = "添加业务属性中的岗位", notes = "添加业务属性中的岗位", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addBussnessAtrrPost", method = RequestMethod.POST)
    ComResponse<Integer> addBussnessAtrrPost(@RequestBody @Validated BusinessPostVO businessPostVO) {
        return businessPostService.addBussnessAtrrPost(businessPostVO);
    }

    @ApiOperation(value = "根据业务属性-获取对应岗位级别列表", notes = "根据业务属性-获取对应岗位级别列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bussinessAtrrCode", value = "业务属性Code", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/getBusinessPostList", method = RequestMethod.GET)
    public ComResponse<List<BusinessPostDto>> getBusiPostListByAttr(@NotNull @Min(1) Integer bussinessAtrrCode) {
        return businessPostService.getBusiPostListByAttr(bussinessAtrrCode);
    }

    @ApiOperation(value = "根据业务属性获取岗位列表", notes = "根据业务属性获取岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bussinessAtrrCode", value = "业务属性Code", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/getPostListByBussinessAttrCode", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostListByBussinessAttrCode(@NotNull @Min(1) Integer bussinessAtrrCode) {
        return businessPostService.getPostListByBussinessAttrCode(bussinessAtrrCode);
    }


    @ApiOperation(value = "根据岗位级别获取已有的指标列表", notes = "根据岗位级别获取对用的指标列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postLevelId", value = "postLevelId", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/getPostLevelIndicatorsList", method = RequestMethod.GET)
    public ComResponse<List<PostLevelIndicatorsDto>> getPostLevelIndicatorsList(@NotNull @Min(1) Integer postLevelId) {
        return businessPostService.getPostLevelIndicatorsList(postLevelId);
    }

//    @ApiOperation(value = "删除岗位级别考核指标", notes = "删除岗位级别考核指标", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "岗位级别考核指标id", required = true, dataType = "Int", paramType = "query")
//    })
//    @RequestMapping(value = "/delPostIndicators", method = RequestMethod.GET)
//    public ComResponse<Integer> delPostIndicators(@NotNull @Min(1) Integer id) {
//        return businessPostService.delPostIndicators(id);
//    }

    @ApiOperation(value = "获取岗位级别的所有指标库", notes = "获取岗位级别的所有指标库", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postLevelId", value = "postLevelId", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/getAllPostIndcatorsList", method = RequestMethod.GET)
    public ComResponse<List<PostLevelIndicatorsDto>> getAllPostIndcatorsList(@NotNull @Min(1) Integer postLevelId) {
        return businessPostService.getAllPostIndcatorsList(postLevelId);
    }

    @ApiOperation(value = "添加或者修改岗位级别对应的指标", notes = "添加或者修改岗位级别对应的指标", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addOrUpdatePostIndicators", method = RequestMethod.POST)
    public ComResponse<Integer> addOrUpdatePostIndicators(@RequestBody @Validated  List<PostLevelIndicatorsVO> postLevelIndicatorsVOList){
        return businessPostService.addOrUpdatePostIndicators(postLevelIndicatorsVOList);
    };
    @ApiOperation(value = "按照时间升级", notes = "按照时间升级")
    @PostMapping(value = "/addOrUpdateDuration")
    public ComResponse<Boolean> addOrUpdateDuration(@RequestBody PostLevelIndicatorsUpDurationVO upDurationVO){

        return businessPostService.addOrUpdateDuration(upDurationVO);
    }
}
