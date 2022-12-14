package cn.net.yzl.ehr.controller.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.async.MsgSendAsync;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.resume.ResumeDepartStaffFeginService;
import cn.net.yzl.staff.dto.resume.ResumeDepartStaffListDto;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffParamsVO;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/resume/departStaff")
@Api(value = "人事管理-面试管理", tags = {"人事管理"})
@Validated
public class ResumeDepartStaffController {

    @Autowired
    private ResumeDepartStaffFeginService resumeDepartStaffFeginService;

@Autowired
private MsgSendAsync msgSendAsync;


    @ApiOperation(value = "个人中心-待筛选-更新", notes = "个人中心-待筛选-更新", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody @Validated ResumeDepartStaffUpdateVO resumeDepartStaffUpdateVO,@ApiIgnore @CurrentStaffNo String staffNo)  {
        ComResponse<String> update = resumeDepartStaffFeginService.update(resumeDepartStaffUpdateVO);
        if(update.getData()!=null){
            msgSendAsync.resumeUpdateInfo(staffNo,update.getData());

        }
        return update;
    }


    @ApiOperation(value = "个人中心-待筛选-分页列表", notes = "个人中心-待筛选-分页列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getResumeDepartStaffList", method = RequestMethod.POST)
    ComResponse<Page<ResumeDepartStaffListDto>> getResumeDepartStaffList(@RequestBody @Validated ResumeDepartStaffParamsVO resumeDepartStaffParamsVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        resumeDepartStaffParamsVO.setStaffNo(staffNo);
        return resumeDepartStaffFeginService.getResumeDepartStaffList(resumeDepartStaffParamsVO);
    }







}
