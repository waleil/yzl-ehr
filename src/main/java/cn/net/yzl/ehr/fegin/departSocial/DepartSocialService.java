package cn.net.yzl.ehr.fegin.departSocial;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.pojo.DepartSalarySettlePo;
import cn.net.yzl.ehr.vo.DepartSocialTypeVo;
import cn.net.yzl.ehr.vo.DepartSocialVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "departSocial",url = "${fegin.api.url}/departSocial")
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient("yzl-staff-db")
public interface DepartSocialService {


    @ApiOperation(value = "新增社保", notes = "新增社保", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("departSocial/insertDepartSocial")
    public ComResponse insertDepartSocial(@RequestBody DepartSocialVo departSocialVo);

    @ApiOperation(value = "查询社保", notes = "查询社保", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @GetMapping("departSocial/selectDepartSocialList")
    public ComResponse<DepartSocialDto> selectDepartSocialList(@RequestParam("departId") Integer departId);

    @ApiOperation(value = "查询缴纳地区和岗位名称", notes = "查询缴纳地区和岗位名称")
    @GetMapping("departSocial/selectPaymentAreaPostName")
    public ComResponse<AreaPostDto> selectPaymentAreaPostName(@RequestParam("departId") Integer departId);

//    @ApiOperation(value = "查询社保详情", notes = "查询社保详情")
//    @GetMapping("departSocial/selectDepartSocialInfo")
//    public ComResponse<DepartSocialInfoDto> selectDepartSocialInfo(@RequestParam("departId") Integer departId,@RequestParam("salaryStart") Integer salaryStart,@RequestParam("salaryEnd") Integer salaryEnd,@RequestParam("isEdit") Integer isEdit);


    @ApiOperation(value = "查询社保详情", notes = "查询社保详情")
    @GetMapping("departSocial/selectDepartSocialInfo")
    public ComResponse<DepartSocialInfoDto> selectDepartSocialInfo(@RequestParam("departId") Integer departId,
                                                                   @RequestParam("id") Integer id,@RequestParam("isEdit") Integer isEdit);

    @ApiOperation(value = "修改社保信息", notes = "修改社保信息", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("departSocial/updateDepartSocial")
    public ComResponse updateDepartSocial(@RequestBody DepartSocialVo departSocialVo);


    @ApiOperation(value = "删除社保信息", notes = "删除社保信息")
    @GetMapping("departSocial/deleteDepartSocial")
    public ComResponse deleteDepartSocial(@RequestParam("departId") Integer departId,@RequestParam("departSocialId") Integer departSocialId);

    @ApiOperation(value = "查询社保种类", notes = "查询社保种类")
    @GetMapping("departSocial/selectSysSocial")
    public  ComResponse<List<SysDictDataDto>> selectSysSocial(@RequestParam("departId") Integer departId);


    @ApiOperation(value = "新增工资发放日与结算日", notes = "新增工资发放日与结算日")
    @PostMapping("departSocial/insertDepartSalarySettle")
    public ComResponse insertDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo);

    @ApiOperation(value = "查询工资发放日与结算日", notes = "查询工资发放日与结算日")
    @GetMapping("departSocial/selectDepartSalarySettle")
    public ComResponse<DepartSalarySettlePo> selectDepartSalarySettle(@RequestParam("departId") Integer departId);

    @ApiOperation(value = "修改工资发放日与结算日", notes = "修改工资发放日与结算日")
    @PostMapping("departSocial/updateDepartSalarySettle")
    public ComResponse updateDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo);


    @ApiOperation(value = "根据部门岗位id获取社保信息", notes = "根据部门岗位id获取社保信息")
    @RequestMapping(value = "departSocial/getSocialItemsNameByDepartPostId", method = RequestMethod.GET)
    public ComResponse<String> getSocialItemsNameByDepartPostId(@RequestParam("departPostId") Integer departPostId);
}
