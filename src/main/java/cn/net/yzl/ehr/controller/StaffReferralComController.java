package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.StaffReferralComService;
import cn.net.yzl.staff.dto.PostDto;
import cn.net.yzl.staff.dto.StaffReferralComDto;
import cn.net.yzl.staff.pojo.StaffReferralComInsertPo;
import cn.net.yzl.staff.pojo.StaffReferralComUpdatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffreferral")
@Api(value = "转介绍提成设置", tags = {"转介绍提成设置"})
public class StaffReferralComController {
    @Autowired
    private StaffReferralComService staffReferralComService;


    @ApiOperation(value = "转介绍提成设置-查询列表信息", notes = "转介绍提成设置-查询列表信息")
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    ComResponse<List<StaffReferralComDto>> getByParams(@RequestParam(value = "departId",required = false) Integer departId, @RequestParam(value = "postId",required = false) Integer postId) {
        return staffReferralComService.getlist(departId,postId);
    }

    @ApiOperation(value = "转介绍提成设置-删除转介绍提成设置信息",notes = "转介绍提成设置-删除转介绍提成设置信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")Integer id) {
        return staffReferralComService .deleteById(id);
    }

    @ApiOperation(value = "转介绍提成设置-根据部门id查询岗位", notes = "转介绍提成设置-根据部门id查询岗位")
    @RequestMapping(value = "/getPost", method = RequestMethod.GET)
    ComResponse<List<PostDto>> getByParams(@RequestParam(value = "departId")Integer departId) {
        return staffReferralComService.getPost(departId);
    }

    @ApiOperation(value = "转介绍提成设置-添加转介绍提成设置信息", notes = "转介绍提成设置-添加转介绍提成设置信息", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody StaffReferralComInsertPo staffReferralComInsertPo) {
        return staffReferralComService.insert(staffReferralComInsertPo);
    }

    @ApiOperation(value = "转介绍提成设置-修改转介绍提成设置信息", notes = "转介绍提成设置-修改转介绍提成设置信息", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    ComResponse<Integer> updateById(@RequestBody StaffReferralComUpdatePo staffReferralComUpdatePo) {
        return staffReferralComService.updateById(staffReferralComUpdatePo);
    }

    @ApiOperation(value = "转介绍提成设置-查询转提成设置详情", notes = "转介绍提成设置-转提成设置详情")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    ComResponse<StaffReferralComDto> detail(@RequestParam(value = "id") Integer id) {
        return staffReferralComService.selectDetail(id);
    }

}
