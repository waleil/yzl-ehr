package cn.net.yzl.ehr.fegin.sysDictData;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.SysDictDataDto;
import cn.net.yzl.ehr.vo.SysDictDataVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(value = "staff",url = "${fegin.db.url}")
@FeignClient(name = "yzl-staff-db")
public interface SysDictDataFeginService {


    @RequestMapping(value = "/sysDic/getByType", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> getByType(@RequestParam("dictType") String dictType);
    @RequestMapping(value = "/sysDic/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertSelective(@RequestBody SysDictDataVO dictDataVO);
}
