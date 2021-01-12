package cn.net.yzl.ehr.fegin.departResume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDictDto;
import cn.net.yzl.ehr.pojo.DepartResumeDictListPo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "post",url = "${fegin.db.url}")
public interface DepartResumeDictFeignService {

    @RequestMapping(value = "/resumeDict/getDictList", method = RequestMethod.GET)
    public ComResponse<List<DepartResumeDictDto>> getDictList();

    @RequestMapping(value = "/resumeDict/getDictById", method = RequestMethod.GET)
    public ComResponse<DepartResumeDictDto> getDictById(@RequestParam("id") Integer id) ;


    @RequestMapping(value = "/resumeDict/selectListByName", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDictDto>> selectListByName(@RequestParam("name") String name) ;

    @RequestMapping(value = "/resumeDict/saveUpdate", method = RequestMethod.POST)
    ComResponse<Integer> saveUpdate(@RequestBody DepartResumeDictListPo listPo);
}
