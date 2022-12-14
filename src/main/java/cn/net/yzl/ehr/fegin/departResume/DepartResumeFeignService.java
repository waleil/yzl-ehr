package cn.net.yzl.ehr.fegin.departResume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeItemDto;
import cn.net.yzl.ehr.dto.DepartResumeNodeDto;
import cn.net.yzl.ehr.pojo.DepartResumeInsertListPo;
import cn.net.yzl.ehr.pojo.DepartResumeUpdateListPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface DepartResumeFeignService {

    @RequestMapping(value = "/conf/resume/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody DepartResumeInsertListPo departResumePo);


    @RequestMapping(value = "/conf/resume/saveUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> saveUpdate(@RequestBody DepartResumeUpdateListPo itemUpdatePo);


    @RequestMapping(value = "/conf/resume/getByDepartId", method = RequestMethod.GET)
    ComResponse<Page<DepartResumeItemDto>> getByDepartId(@RequestParam("departId") Integer departId, @RequestParam("pageNo") Integer pageNo,
                                                         @RequestParam("pageSize") Integer pageSize);


    @RequestMapping(value = "/conf/resume/getByDepartPostId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeNodeDto>> getByDepartPostId(@RequestParam("departPostId") Integer departPostId);

    @RequestMapping(value = "/conf/resume/getByResumeId", method = RequestMethod.GET)
    ComResponse<DepartResumeDto> getByResumeId(@RequestParam("resumeId") Integer resumeId);


    @RequestMapping(value = "/conf/resume/deleteByResumeId", method = RequestMethod.POST)
    ComResponse<Integer> deleteByResumeId(@RequestParam("resumeId") Integer resumeId, @RequestParam("updator") String updator);

}
