package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import cn.net.yzl.ehr.vo.DepartResumeUpdateVO;
import cn.net.yzl.ehr.vo.DepartResumeVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * 部门的 fegin client
 */

@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
@Repository
public interface DepartResumeFeginService {
    @RequestMapping(value = "/conf/resume/add", method = RequestMethod.POST)
    ComResponse<Integer> add( @RequestParam("strJson") String strJson);
    @RequestMapping(value = "/conf/resume/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody DepartResumeUpdateVO departResumeUpdateVO);
    @RequestMapping(value = "/conf/resume/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDto>> getByDepartId(@RequestParam("departId") Integer departId);
    @RequestMapping(value = "/conf/resume/getByPostId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDto>> getByPostId(@RequestParam("postId") @Min(1) Integer postId) ;
    @RequestMapping(value = "/conf/resume/deleteByPostId", method = RequestMethod.POST)
    ComResponse<Integer> deleteByPostId(@RequestParam("postId") @Min(1) Integer postId) ;
}
