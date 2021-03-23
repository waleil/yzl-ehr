package cn.net.yzl.ehr.fegin.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.pojo.deduct.DeductItemInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdatePo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdateStatePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(value = "staff",url = "127.0.0.1:38080/")
//@FeignClient(name = "yzl-staff-db")
public interface DeductItemFeginService {


    @ApiOperation(value = "查询扣款类型",notes = "查询扣款类型",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deduct/queryAll", method = RequestMethod.GET)
    ComResponse<List<DeductItemDto>> queryAll();

    @ApiOperation(value = "添加扣款类型", notes = "添加扣款类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deduct/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody DeductItemInsertPo insertPo);

    @ApiOperation(value = "修改扣款类型", notes = "修改扣款类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deduct/updateByState",method = RequestMethod.POST)
    ComResponse<Integer> updateByState (@RequestBody DeductItemUpdateStatePo updatePo);

    @ApiOperation(value = "查询所有",notes = "查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deduct/queryItem", method = RequestMethod.GET)
    ComResponse<Page<DeductItemDto>> queryItem(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize")Integer pageSize);

    @ApiOperation(value ="编辑扣款类型" ,notes ="编辑扣款类型",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deduct/update",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody DeductItemUpdatePo updatePo);

}
