package cn.net.yzl.ehr.fegin.businessPost;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.BusinessPostDto;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelIndicatorsDto;
import cn.net.yzl.ehr.vo.BusinessPostVO;
import cn.net.yzl.ehr.vo.DepartAttendRpVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

//@FeignClient(value = "businessPost",url = "${fegin.db.url}")
@FeignClient(name = "yzl-staff-db")
public interface BusinessPostFeginService {


    @RequestMapping(value = "/businessPost/addBussnessAtrrPost", method = RequestMethod.POST)
    ComResponse<Integer> addBussnessAtrrPost(@RequestBody @Validated BusinessPostVO businessPostVO) ;

    @RequestMapping(value = "/businessPost/getBusinessPostList", method = RequestMethod.GET)
    public ComResponse<List<BusinessPostDto>> getBusiPostListByAttr(@RequestParam("bussinessAtrrCode") Integer bussinessAtrrCode);

    @RequestMapping(value = "/businessPost/getPostListByBussinessAttrCode", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostListByBussinessAttrCode(@RequestParam("bussinessAtrrCode") Integer bussinessAtrrCode);

    @RequestMapping(value = "/businessPost/getPostLevelIndicatorsList", method = RequestMethod.GET)
    public ComResponse<List<PostLevelIndicatorsDto>> getPostLevelIndicatorsList(@RequestParam("postLevelId") Integer postLevelId);

    @RequestMapping(value = "/businessPost/delPostIndicators", method = RequestMethod.GET)
    public ComResponse<Integer> delPostIndicators(@RequestParam("id")  Integer id);

    @RequestMapping(value = "/businessPost/getAllPostIndcatorsList", method = RequestMethod.GET)
    public ComResponse<List<PostLevelIndicatorsDto>> getAllPostIndcatorsList(@RequestParam("postLevelId") Integer postLevelId);
}
