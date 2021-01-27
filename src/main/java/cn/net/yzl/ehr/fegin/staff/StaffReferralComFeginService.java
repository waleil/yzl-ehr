package cn.net.yzl.ehr.fegin.staff;

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
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface StaffReferralComFeginService {

    @ApiOperation(value = "查询列表信息", notes = "查询列表信息")
    @RequestMapping(value = "/staffReferralCom/getlist", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<List<StaffReferralComDto>> getlist(@RequestParam(value = "departId",required = false) Integer departId, @RequestParam(value = "postId",required = false) Integer postId);

    @ApiOperation(value = "删除转介绍提成设置信息", notes = "删除转介绍提成设置信息")
    @RequestMapping(value = "/staffReferralCom/deleteById", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<Integer> deleteById(@RequestParam("id")Integer id);

    @ApiOperation(value = "添加转介绍提成设置信息", notes = "添加转介绍提成设置信息")
    @RequestMapping(value = "/staffReferralCom/insert", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> insert(@RequestBody StaffReferralComInsertPo staffReferralComInsertPo);

    @ApiOperation(value = "修改转介绍提成设置信息", notes = "修改转介绍提成设置信息")
    @RequestMapping(value = "/staffReferralCom/updateById", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> updateById(@RequestBody StaffReferralComUpdatePo staffReferralComUpdatePo);

    @ApiOperation(value = "根据部门id查询岗位", notes = "根据部门id查询岗位")
    @RequestMapping(value = "/staffReferralCom/getPost", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<List<PostDto>> getPost(@RequestParam(value = "departId")Integer departId);

    @ApiOperation(value = "查询转提成设置详情", notes = "查询转提成设置详情")
    @RequestMapping(value = "/staffReferralCom/detail", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<StaffReferralComDto> detail(@RequestParam(value = "id") Integer id);

}
