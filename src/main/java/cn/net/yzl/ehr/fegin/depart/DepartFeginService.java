package cn.net.yzl.ehr.fegin.depart;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.pojo.DepartPo;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import feign.Param;
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
//@FeignClient(name = "yzl-staff-api")
@FeignClient(value = "staff",url = "${fegin.api.url}")
@Repository
public interface DepartFeginService {


    @RequestMapping(value = "/depart/create", method = RequestMethod.POST)
    ComResponse<String> create(@RequestBody DepartPo departPo);

    @RequestMapping(value = "/depart/getByDingDepartId", method = RequestMethod.GET)
    ComResponse<DepartPo> getByDingDepartId(@RequestParam("dingDepartId") String dingDepartId);

    // 获取部门列表
    @RequestMapping(value = "/depart/getTreeList", method = RequestMethod.GET)
    ComResponse<DepartDto> getTreeList();
    @RequestMapping(value = "/depart/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody DepartVO departVO);
    @RequestMapping(value = "/depart/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody DepartUpdateVO departUpdateVO);
    @RequestMapping(value = "/depart/del", method = RequestMethod.GET)
    ComResponse<String> del(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/depart/getByUserNo", method = RequestMethod.GET)
    ComResponse<DepartDto> getByUserNo(@RequestParam("userNo")String userNo);
    @RequestMapping(value = "/depart/getChildById", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getChildById(@RequestParam("id") Integer id);
}
