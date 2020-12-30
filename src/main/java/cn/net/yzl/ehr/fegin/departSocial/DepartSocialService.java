package cn.net.yzl.ehr.fegin.departSocial;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.pojo.DepartSalarySettlePo;
import cn.net.yzl.ehr.vo.DepartSocialTypeVo;
import cn.net.yzl.ehr.vo.DepartSocialVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "departSocial",url = "${fegin.api.url}/departSocial")
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient("yzl-staff-db")
public interface DepartSocialService {

    @GetMapping("departSocial/selectDepartSocialType")
    public ComResponse<DepartSocialTypeDto> selectDepartSocialType(@RequestParam("departId") Integer departId, @RequestParam(value = "checkFlag", required = false) Integer checkFlag);


    @PostMapping("departSocial/insertDepartSocialType")
    public ComResponse insertDepartSocialType(@RequestBody DepartSocialTypeVo departSocialTypeVo);

    @GetMapping("departSocial/deleteDepartSocialType")
    public ComResponse deleteDepartSocialType(@RequestParam("ids") Integer[] ids);

    @PostMapping("departSocial/updateDepartSocialType")
    public ComResponse updateDepartSocialType(@RequestBody DepartSocialTypeVo departSocialTypeVo);


    @PostMapping("departSocial/insertDepartSocial")
    public ComResponse insertDepartSocial(@RequestBody DepartSocialVo departSocialVo);

    @GetMapping("departSocial/selectDepartSocialList")
    public ComResponse<DepartSocialDto> selectDepartSocialList(@RequestParam("departId") Integer departId);


    @GetMapping("departSocial/selectPaymentAreaPostName")
    public ComResponse<AreaPostDto> selectPaymentAreaPostName(@RequestParam("departId") Integer departId);

    @GetMapping("departSocial/selectDepartSocialInfo")
    public ComResponse<DepartSocialInfoDto> selectDepartSocialInfo(@RequestParam("departId") Integer departId, @RequestParam("id") Integer id);

    @PostMapping("departSocial/updateDepartSocial")
    public ComResponse updateDepartSocial(@RequestBody DepartSocialVo departSocialVo);


    @PostMapping("departSocial/insertDepartSalarySettle")
    public ComResponse insertDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo);

    @PostMapping("departSocial/selectDepartSalarySettle")
    public ComResponse<DepartSalarySettlePo> selectDepartSalarySettle(@RequestParam("departId") Integer departId);

    @PostMapping("departSocial/updateDepartSalarySettle")
    public ComResponse updateDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo);

    @GetMapping("departSocial/deleteDepartSocial")
    public ComResponse deleteDepartSocial(@RequestParam("departId") Integer departId,@RequestParam("departSocialId") Integer departSocialId);

}
