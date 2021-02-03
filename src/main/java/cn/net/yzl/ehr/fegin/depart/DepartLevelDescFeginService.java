package cn.net.yzl.ehr.fegin.depart;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.depart.DepartLevelDescDto;
import cn.net.yzl.staff.vo.depart.DepartLevelDescUpdateVO;
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

import java.util.List;


@FeignClient(value = "DepartLevelDescFeginService",url = "${fegin.db.url}/departLevel")
public interface DepartLevelDescFeginService {




    @RequestMapping(value = "/getDepartLevelList", method = RequestMethod.GET)
    ComResponse<List<DepartLevelDescDto>> getDepartLevelList();

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody @Validated List<DepartLevelDescUpdateVO> departLevelDescUpdateVOList);
}
