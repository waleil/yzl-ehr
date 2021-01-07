package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.pojo.DepartResumeItemPo;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 部门的 fegin client
 */

//@FeignClient(value = "staff",url = "${fegin.db.url}")
@FeignClient(name = "yzl-staff-db")
@Repository
public interface DepartResumeFeginService {

    @RequestMapping(value = "/conf/resume/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody DepartResumePo departResumePo);

    @RequestMapping(value = "/conf/resume/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody DepartResumeItemPo departResumeItemPo);

    @RequestMapping(value = "/conf/resume/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDto>> getByDepartId(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/conf/resume/getByResumeId", method = RequestMethod.GET)
    ComResponse<DepartResumeDto> getByResumeId(@RequestParam("resumeId") Integer resumeId);

    @RequestMapping(value = "/conf/resume/getByPostId", method = RequestMethod.GET)
    ComResponse<DepartResumeDto> getByPostId(@RequestParam("departId") Integer departId,@RequestParam("postId") Integer postId) ;

    @RequestMapping(value = "/conf/resume/deleteByResumeId", method = RequestMethod.POST)
    ComResponse<Integer> deleteByResumeId(@RequestParam("resumeId") Integer resumeId, @RequestParam("updator") String updator) ;





}
