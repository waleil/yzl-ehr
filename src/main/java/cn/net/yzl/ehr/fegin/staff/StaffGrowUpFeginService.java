package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*@Repository
@FeignClient(name = "yzl-staff-db")
public interface StaffGrowUpFeginService {

 *//*   @ApiOperation(value = "查询员工奖惩记录",notes = "查询员工奖惩记录",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/findByStaffNo", method = RequestMethod.GET)
    ComResponse<List<StaffUpRpPo>> findByStaffNo (@RequestBody String staffNO);

    @ApiOperation(value = "删除奖惩信息",notes = "删除奖惩信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(Integer id, String updator);


    @ApiOperation(value = "添加奖惩信息", notes = "添加奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert (@RequestBody List<StaffUpRpInsertPo> staff);

    @ApiOperation(value = "修改奖惩信息", notes = "修改奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffUpRpUpdatePo staffUpRpUpdatePo);

    @ApiOperation(value = "保存奖惩信息", notes = "保存奖惩信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffUpRpItemPo staffUpRpItemPo);


    @ApiOperation(value = "查询员工培训记录",notes = "查询员工培训记录",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    ComResponse<List<StaffUpTrainPo>> find (String staffNO);

    @ApiOperation(value = "删除培训信息",notes = "删除培训信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteTrain",method = RequestMethod.GET)
    ComResponse<Integer> delectTrain(Integer id, String updator);


    @ApiOperation(value = "添加培训信息", notes = "添加培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/addTrain",method = RequestMethod.POST)
    ComResponse<Integer> addTrain (@RequestBody List<StaffUpTrainInsertPo> staff);

    @ApiOperation(value = "修改培训信息", notes = "修改培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateTrain",method = RequestMethod.POST)
    ComResponse<Integer> updateTrain (@RequestBody StaffUpTrainUpdatePo staffUpTrainUpdatePo);

    @ApiOperation(value = "保存培训信息", notes = "保存培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDateTrain",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDateTrain(@RequestBody StaffUpTrainItemPo staffUpTrainItemPo);


  *//*


}*/
