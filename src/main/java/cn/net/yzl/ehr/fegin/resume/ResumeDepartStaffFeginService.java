package cn.net.yzl.ehr.fegin.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.resume.ResumeDepartStaffListDto;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffParamsVO;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/resume/departStaff")
public interface ResumeDepartStaffFeginService {


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody ResumeDepartStaffUpdateVO resumeDepartStaffUpdateVO);

    @RequestMapping(value = "/getResumeDepartStaffList", method = RequestMethod.POST)
    ComResponse<Page<ResumeDepartStaffListDto>> getResumeDepartStaffList(@RequestBody ResumeDepartStaffParamsVO resumeDepartStaffParamsVO);


}
