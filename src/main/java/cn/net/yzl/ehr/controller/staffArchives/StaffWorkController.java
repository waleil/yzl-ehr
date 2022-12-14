package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/staff/staffwork")
@Api(value = "员工工作经历", tags = {"员工档案"})
public class StaffWorkController {
    @Autowired
    private StaffWorkService staffWorkService;

    @ApiOperation(value = "工作经历信息-查询员工工作经历信息",notes = "查询员工工作经历信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ComResponse<StaffWorkListDto> list(@RequestParam("staffNo") @NotBlank String staffNo) {
        return staffWorkService.list(staffNo);
    }

/*    @ApiOperation(value = "工作经历-删除工作经历信息",notes = "删除工作经历信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(Integer id) {
        return staffWorkService .deleteById(id);
    }


    @ApiOperation(value = "工作经历-添加工作经历信息", notes = "添加工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody StaffWorkInsertListPo staffWorkList) {
        return staffWorkService.insert(staffWorkList);
    }


    @ApiOperation(value = "工作经历-修改工作经历信息", notes = "修改工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffWorkUpdatePo WorkPo){
        return staffWorkService.update(WorkPo);
    }

    @ApiOperation(value = "工作经历信息-批量修改工作经历信息", notes = "批量修改工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updatelist",method = RequestMethod.POST)
    ComResponse<Integer> updateList (@RequestBody StaffWorkUpdateListPo staffWorkUpdateListPo){
        return staffWorkService.updatelist(staffWorkUpdateListPo);
    }
    @ApiOperation(value = "工作经历信息-保存工作经历信息", notes = "保存工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffWorkItemPo staffWorkItemPo){
        return staffWorkService.saveUpDate(staffWorkItemPo);
*/
    @ApiOperation(value = "工作经历-保存工作经历信息", notes = "保存工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffWorkItemPo staffWorkItemPo, @CurrentStaffNo @ApiIgnore String staffNo){
        return staffWorkService.saveUpDate(staffWorkItemPo,staffNo);
    }

}
