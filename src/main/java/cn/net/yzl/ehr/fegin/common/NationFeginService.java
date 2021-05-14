package cn.net.yzl.ehr.fegin.common;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.common.NationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "yzl-common-zt")
public interface NationFeginService {

    @RequestMapping(value = "/nation/getAllNation", method = RequestMethod.GET)
    ComResponse<List<NationDto>> getAllNation();


}
