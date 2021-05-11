package cn.net.yzl.ehr.fegin.common;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.SysDictDataDto;
import cn.net.yzl.ehr.vo.SysDictDataVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface SysDictDataFeginService {


    @RequestMapping(value = "/sysDic/getByType", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> getByType(@RequestParam("dictType") String dictType);

    @RequestMapping(value = "/sysDic/addOrUpdate", method = RequestMethod.POST)
    ComResponse<Integer> addOrUpdate(@RequestBody List<SysDictDataVO> dictDataList);


}
