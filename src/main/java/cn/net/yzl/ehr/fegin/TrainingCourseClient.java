package cn.net.yzl.ehr.fegin;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.train.CoursewareDto;
import cn.net.yzl.staff.dto.train.StaffTrainingInfoDto;
import cn.net.yzl.staff.dto.train.TrainInfoAllDto;
import cn.net.yzl.staff.pojo.train.StaffTrainProductPo;
import cn.net.yzl.staff.pojo.train.TrainSchedulePo;
import cn.net.yzl.staff.pojo.train.TrainStaffRelationPo;
import cn.net.yzl.staff.pojo.train.TrainStaffSignPo;
import cn.net.yzl.staff.pojo.train.TrainingCourseDetailPo;
import cn.net.yzl.staff.vo.train.SignInputScore;
import cn.net.yzl.staff.vo.train.TrainInfoAllVO;
import cn.net.yzl.staff.vo.train.TrainSubsidySysVO;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}/trainCourse")
public interface TrainingCourseClient {

    @GetMapping("/selectStaffTrainProduct")
    ComResponse<List<StaffTrainProductPo>> selectStaffTrainProduct(@RequestParam("staffNo") String staffNo, @RequestParam("size") Integer size);

    @PostMapping("/insertTrainCourse")
    ComResponse insertTrainCourse(@RequestBody TrainInfoAllVO trainInfoAllVO);

    @PostMapping("/insertUpdateDelTrainSubsidySys")
    ComResponse insertUpdateDelTrainSubsidySys(@RequestBody TrainSubsidySysVO trainSubsidySysVO);

    @PostMapping("/selectTrainSubsidySys")
    ComResponse selectTrainSubsidySys();

    @GetMapping("/selectTrainInfo")
    ComResponse<TrainInfoAllDto> selectTrainInfo(@RequestParam("id") Integer id);

    @GetMapping("/selectCourseInfoForStaff")
    public ComResponse<List<StaffTrainingInfoDto>> selectCourseInfoForStaff(@RequestParam("staffNo") String staffNo);

    @PostMapping("/editTrainInfo")
    ComResponse editTrainInfo(@RequestBody TrainInfoAllVO trainInfoAllVO);

    @GetMapping("/listCourse")
    ComResponse<Page<TrainingCourseDetailPo>> list(
            @ApiParam(value = "????????????") @RequestParam(value = "courseName", required = false) String courseName,
            @ApiParam(value = "???????????????0?????? 1??????") @RequestParam(value = "online", required = false) Integer online,
            @ApiParam(value = "???????????? 0??? 1???") @RequestParam(value = "exam", required = false) Integer exam,
            @ApiParam(value = "????????????(0 ?????????,1 ?????????,2 ????????????)") @RequestParam(value = "status", required = false) Integer status,
            @ApiParam(value = "??????????????????") @RequestParam(value = "startTime", required = false) String startTime,
            @ApiParam(value = "??????????????????") @RequestParam(value = "endTime", required = false) String endTime,
            @ApiParam(value = "????????????:??????") @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @ApiParam(value = "????????????:????????????") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize);

    @GetMapping("/selectProduct")
    ComResponse<List<String>> selectProduct();

    @GetMapping("/queryTrainingScheduleList")
    ComResponse<List<TrainSchedulePo>> queryTrainingScheduleList(@ApiParam(value = "?????????id") @RequestParam(value = "id", required = false) Integer id);

    @GetMapping("/findById")
    ComResponse<TrainInfoAllDto> findById(@ApiParam(value = "?????????id") @RequestParam(value = "id") Integer id);

    @GetMapping("/findProduct")
    ComResponse findProduct();

    @GetMapping("/findSign")
    ComResponse<List<Object>> findSign(
            @ApiParam(value = "????????????") @RequestParam(value = "name", required = false) String name,
            @ApiParam(value = "??????") @RequestParam(value = "departCode", required = false) Integer departCode,
            @ApiParam(value = "?????????") @RequestParam(value = "partner", required = false) Integer partner,
            @ApiParam(value = "??????") @RequestParam(value = "workplace", required = false) Integer workplace,
            @ApiParam(value = "????????????") @RequestParam(value = "postId", required = false) Integer postId,
            @ApiParam(value = "????????????:180 ????????? 181 ?????????") @RequestParam(value = "enterStatus", required = false) Integer enterStatus,
            @ApiParam(value = "??????id") @RequestParam(value = "id") Integer id,
            @ApiParam(value = "????????????:??????") @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @ApiParam(value = "????????????:????????????") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize);

    @PostMapping("/staffCourseSign")
    ComResponse staffCourseSign(@RequestBody List<SignInputScore> list);

    @PostMapping("/staffCourseGrade")
    ComResponse staffCourseGrade(@RequestBody @Validated List<SignInputScore> list);

    @PostMapping("/staffSign")
    ComResponse staffSign(@RequestBody List<TrainStaffSignPo> list);

    @PostMapping("/staffEntryPost")
    ComResponse<Integer> staffEntryPost(@RequestBody TrainStaffRelationPo trainStaffRelationPo);

    @GetMapping("/getPartner")
    ComResponse<List<Map<String, Object>>> getPartner(@RequestParam("type") String type);

    @GetMapping("/listCoursewareDto")
    ComResponse<Page<CoursewareDto>> listCoursewareDto(@RequestParam("name") String name, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @GetMapping("/productList")
    ComResponse productList(@RequestParam("name") String name, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    @GetMapping("queryDateBycourseid")
    ComResponse<Date> queryDateBycourseid(@RequestParam("courseId") Integer courseId);
}
