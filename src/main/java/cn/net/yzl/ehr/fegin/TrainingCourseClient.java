package cn.net.yzl.ehr.fegin;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.train.CoursewareDto;
import cn.net.yzl.staff.dto.train.TrainInfoAllDto;
import cn.net.yzl.staff.pojo.train.*;
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

import java.util.List;
import java.util.Map;

@FeignClient(name = "trainingCourse",url = "${fegin.db.url}/trainCourse")
//@FeignClient(name = "trainingCourse",url = "localhost:38080/trainCourse")
public interface TrainingCourseClient {

    @GetMapping("/selectStaffTrainProduct")
    ComResponse<List<StaffTrainProductPo>> selectStaffTrainProduct(@RequestParam("staffNo") String staffNo,@RequestParam("size")  Integer size);

    @PostMapping("/insertTrainCourse")
    ComResponse insertTrainCourse(TrainInfoAllVO trainInfoAllVO);

    @PostMapping("/insertUpdateDelTrainSubsidySys")
    ComResponse insertUpdateDelTrainSubsidySys(TrainSubsidySysVO trainSubsidySysVO);

    @PostMapping("/selectTrainSubsidySys")
    ComResponse selectTrainSubsidySys();

    @GetMapping("/selectTrainInfo")
    ComResponse<TrainInfoAllDto> selectTrainInfo(@RequestParam("id") Integer id);

    @PostMapping("/editTrainInfo")
    ComResponse editTrainInfo(@RequestBody TrainInfoAllDto trainInfoAllDto);

    @GetMapping("/listCourse")
    ComResponse<List<TrainingCourseDetailPo>> list(
            @ApiParam(value = "商品名称") @RequestParam(value = "courseName", required = false) String courseName,
            @ApiParam(value = "培训方式，0线上 1线下") @RequestParam(value = "online", required = false) Integer online,
            @ApiParam(value = "是否考试 0否 1是") @RequestParam(value = "exam", required = false) Integer exam,
            @ApiParam(value = "培训状态(0 未开始,1 培训中,2 培训完成)") @RequestParam(value = "status", required = false) Integer status,
            @ApiParam(value = "培训开始时间") @RequestParam(value = "startTime", required = false) String startTime,
            @ApiParam(value = "培训结束时间") @RequestParam(value = "endTime", required = false) String endTime,
            @ApiParam(value = "分页参数:页码")@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
            @ApiParam(value = "分页参数:每页数量")@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize);

    @GetMapping("/selectProduct")
    ComResponse<List<String>> selectProduct();

    @GetMapping("/queryTrainingScheduleList")
    ComResponse<List<TrainSchedulePo>> queryTrainingScheduleList(@ApiParam(value = "课程表id")@RequestParam(value = "id",required = false)Integer id);

    @GetMapping("/findById")
    ComResponse<TrainInfoAllDto> findById(@ApiParam(value = "课程表id")@RequestParam(value = "id")Integer id);

    @GetMapping("/findProduct")
    ComResponse findProduct();

    @GetMapping("/findSign")
    ComResponse<List<Object>> findSign(
            @ApiParam(value = "课程id")@RequestParam(value = "id")Integer id,
            @ApiParam(value = "员工姓名")@RequestParam(value = "name",required = false) String name,
            @ApiParam(value = "部门")@RequestParam(value = "departCode",required = false) Integer departCode,
            @ApiParam(value = "合作方")@RequestParam(value = "partner",required = false)Integer partner,
            @ApiParam(value = "职场")@RequestParam(value = "workplace",required = false) Integer workplace,
            @ApiParam(value = "岗位名称")@RequestParam(value = "postId",required = false) Integer postId,
            @ApiParam(value = "分页参数:页码")@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
            @ApiParam(value = "分页参数:每页数量")@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize);

    @PostMapping("/staffCourseSign")
    ComResponse staffCourseSign(@RequestBody List<SignInputScore> list);

    @PostMapping("/staffCourseGrade")
    ComResponse staffCourseGrade(@RequestBody @Validated List<SignInputScore> list);

    @PostMapping("/staffSign")
    ComResponse staffSign(@RequestBody List<TrainStaffSignPo> list);

    @PostMapping("/staffEntryPost")
    ComResponse<Integer> staffEntryPost(TrainStaffRelationPo trainStaffRelationPo);

    @GetMapping("/getPartner")
    ComResponse<List<Map<String,Object>>> getPartner(@RequestParam("type") String type);

    @GetMapping("/listCoursewareDto")
    ComResponse<List<CoursewareDto>> listCoursewareDto(@RequestParam("name") String name, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @GetMapping("/productList")
    ComResponse productList(@RequestParam("name") String name,@RequestParam("pageNo")  Integer pageNo,@RequestParam("pageSize")  Integer pageSize);
}
