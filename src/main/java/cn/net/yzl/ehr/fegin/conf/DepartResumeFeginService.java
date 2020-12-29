package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import cn.net.yzl.ehr.util.ValidList;
import cn.net.yzl.ehr.vo.DepartResumeInsertPo;
import cn.net.yzl.ehr.vo.DepartResumeItemPo;
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

@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
@Repository
public interface DepartResumeFeginService {
    @RequestMapping(value = "/conf/resume/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody ValidList<DepartResumeInsertPo> departResumeList);
    @RequestMapping(value = "/conf/resume/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody DepartResumeItemPo itemUpdatePo);
    @RequestMapping(value = "/conf/resume/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDto>> getByDepartId(@RequestParam("departId") Integer departId);
    @RequestMapping(value = "/conf/resume/getByPostId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDto>> getByPostId(@RequestParam("postId") Integer postId) ;
    @RequestMapping(value = "/conf/resume/deleteByPostId", method = RequestMethod.POST)
    ComResponse<Integer> deleteByPostId(@RequestParam("postId") Integer postId, @RequestParam("updator") String updator) ;



}
