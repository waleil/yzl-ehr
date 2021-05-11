package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffUpRpListDto;
import cn.net.yzl.ehr.dto.StaffUpTrainListDto;
import cn.net.yzl.ehr.pojo.StaffUpRpInsertPo;
import cn.net.yzl.ehr.pojo.StaffUpRpItemPo;
import cn.net.yzl.ehr.pojo.StaffUpRpUpdatePo;
import cn.net.yzl.ehr.pojo.StaffUpTrainInsertPo;
import cn.net.yzl.ehr.pojo.StaffUpTrainItemPo;
import cn.net.yzl.ehr.pojo.StaffUpTrainUpdatePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface StaffGrowUpFeginService {

    @ApiOperation(value = "查询员工奖惩记录", notes = "查询员工奖惩记录", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/findByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffUpRpListDto> findByStaffNo(@RequestParam("staffNO") String staffNO);

    @ApiOperation(value = "删除奖惩信息", notes = "删除奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/deleteById", method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @RequestParam("updator") String updator);


    @ApiOperation(value = "添加奖惩信息", notes = "添加奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/insert", method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody List<StaffUpRpInsertPo> staff);

    @ApiOperation(value = "修改奖惩信息", notes = "修改奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/upadte", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody StaffUpRpUpdatePo staffUpRpUpdatePo);

    @ApiOperation(value = "保存奖惩信息", notes = "保存奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/saveUpDate", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffUpRpItemPo staffUpRpItemPo);


    @ApiOperation(value = "查询员工培训记录", notes = "查询员工培训记录", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/find", method = RequestMethod.GET)
    ComResponse<StaffUpTrainListDto> find(@RequestParam("staffNO") String staffNO);

    @ApiOperation(value = "删除培训信息", notes = "删除培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/deleteTrain", method = RequestMethod.GET)
    ComResponse<Integer> delectTrain(@RequestParam("id") Integer id, @RequestParam("updator") String updator);


    @ApiOperation(value = "添加培训信息", notes = "添加培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/addTrain", method = RequestMethod.POST)
    ComResponse<Integer> addTrain(@RequestBody List<StaffUpTrainInsertPo> staff);

    @ApiOperation(value = "修改培训信息", notes = "修改培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/updateTrain", method = RequestMethod.POST)
    ComResponse<Integer> updateTrain(@RequestBody StaffUpTrainUpdatePo staffUpTrainUpdatePo);

    @ApiOperation(value = "保存培训信息", notes = "保存培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staffGrowUp/saveUpDateTrain", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDateTrain(@RequestBody StaffUpTrainItemPo staffUpTrainItemPo);


}
