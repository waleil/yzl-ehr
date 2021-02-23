package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.TrainingCourseClient;
import cn.net.yzl.staff.dto.train.CoursewareDto;
import cn.net.yzl.staff.dto.train.TrainInfoAllDto;
import cn.net.yzl.staff.pojo.train.*;
import cn.net.yzl.staff.vo.train.SignInputScore;
import cn.net.yzl.staff.vo.train.TrainInfoAllVO;
import cn.net.yzl.staff.vo.train.TrainSubsidySysVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "trainingCourse")
@Api(value="培训",tags={"培训模块"})
public class TrainingCourseController {

    @Autowired
    private TrainingCourseClient trainingCourseClient;


    /**
     * 获取员工培训过得商品及成绩
     *
     * @param staffNo 员工编号
     * @param size    取多少条数据
     * @return
     */
    @ApiOperation("获取员工培训过得商品及成绩")
    @GetMapping("selectStaffTrainProduct")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "员工编号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "查询多少条", dataType = "Int", paramType = "query")
    })
    public ComResponse<List<StaffTrainProductPo>> selectStaffTrainProduct(@RequestParam(value = "staffNo", required = false) String staffNo, @RequestParam(value = "size", required = false) Integer size) {
        return trainingCourseClient.selectStaffTrainProduct(staffNo, size);
    }

//    public ComResponse<List<ProductGradeStaffPo>>


    @ApiOperation(value = "新增培训课程信息", notes = "新增培训课程信息")
    @PostMapping("insertTrainCourse")
    public ComResponse insertTrainCourse(@RequestBody TrainInfoAllVO trainInfoAllVO) {
        return trainingCourseClient.insertTrainCourse(trainInfoAllVO);
    }


    @ApiOperation(value = "新增修改删除培训补贴配置", notes = "新增修改删除培训补贴配置")
    @PostMapping("insertUpdateDelTrainSubsidySys")
    public ComResponse insertUpdateDelTrainSubsidySys(@RequestBody TrainSubsidySysVO trainSubsidySysVO) {
        return trainingCourseClient.insertUpdateDelTrainSubsidySys(trainSubsidySysVO);
    }

    @ApiOperation(value = "查询培训补贴配置", notes = "查询培训补贴配置")
    @PostMapping("selectTrainSubsidySys")
    public ComResponse selectTrainSubsidySys() {
        return trainingCourseClient.selectTrainSubsidySys();
    }


    @ApiOperation(value = "查询培训课程详情", notes = "查询培训课程详情")
    @ApiImplicitParam(name = "id", value = "培训课程id", required = true, dataType = "Int", paramType = "query")
    @GetMapping("selectTrainInfo")
    public ComResponse<TrainInfoAllDto> selectTrainInfo(Integer id) {
        return trainingCourseClient.selectTrainInfo(id);
    }


/*    @ApiOperation(value = "查询所有培训商品编码", notes = "查询所有培训商品编码")
    @GetMapping("getTrainProduct")
    public ComResponse<List<String>> getTrainProduct() {
        return trainCourseService.getTrainProduct();
    }*/

    @ApiOperation(value = "培训课程编辑", notes = "培训编辑")
    @PostMapping("editTrainInfo")
    public ComResponse editTrainInfo(@RequestBody TrainInfoAllDto trainInfoAllDto) {
        return trainingCourseClient.editTrainInfo(trainInfoAllDto);
    }

    @ApiOperation(value = "培训课程查询", notes = "培训课程查询")
    @GetMapping("listCourse")
    public ComResponse<List<TrainingCourseDetailPo>> list(
            @ApiParam(value = "商品名称") @RequestParam(value = "courseName", required = false) String courseName,
            @ApiParam(value = "培训方式，0线上 1线下") @RequestParam(value = "online", required = false) Integer online,
            @ApiParam(value = "是否考试 0否 1是") @RequestParam(value = "exam", required = false) Integer exam,
            @ApiParam(value = "培训状态(0 未开始,1 培训中,2 培训完成)") @RequestParam(value = "status", required = false) Integer status,
            @ApiParam(value = "培训开始时间") @RequestParam(value = "startTime", required = false) String startTime,
            @ApiParam(value = "培训结束时间") @RequestParam(value = "endTime", required = false) String endTime,
            @ApiParam(value = "分页参数:页码")@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
            @ApiParam(value = "分页参数:每页数量")@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {

        return trainingCourseClient.list(courseName, online, exam, status, startTime, endTime,pageNum,pageSize);
    }


    @ApiOperation(value = "查询培训过商品",notes = "查询培训过商品")
    @GetMapping("selectProduct")
    public ComResponse<List<String>> selectProduct() {
        return trainingCourseClient.selectProduct();
    }


    @ApiOperation(value = "查询培训计划信息",notes = "查询培训计划信息")
    @GetMapping("queryTrainingScheduleList")
    public ComResponse<List<TrainSchedulePo>> queryTrainingScheduleList(@ApiParam(value = "课程表id")@RequestParam(value = "id",required = false)Integer id){
        return trainingCourseClient.queryTrainingScheduleList(id);
    }

    @ApiOperation(value = "查询课程详情信息",notes = "查询课程详情信息")
    @GetMapping("findById")
    public ComResponse<TrainInfoAllDto> findById(@ApiParam(value = "课程表id")@RequestParam(value = "id")Integer id){
        return trainingCourseClient.findById(id);
    }

    @ApiOperation(value = "商品列表",notes = "商品列表")
    @GetMapping("findProduct")
    public ComResponse findProduct(){
        return trainingCourseClient.findProduct();
    }

    @ApiOperation(value = "查询签到列表",notes = "查询签到列表")
    @GetMapping("findSign")
    public ComResponse<List<Object>> findSign(
            @ApiParam(value = "员工姓名")@RequestParam(value = "name",required = false) String name,
            @ApiParam(value = "部门")@RequestParam(value = "departCode",required = false) Integer departCode,
            @ApiParam(value = "合作方")@RequestParam(value = "partner",required = false)Integer partner,
            @ApiParam(value = "职场")@RequestParam(value = "workplace",required = false) Integer workplace,
            @ApiParam(value = "岗位名称")@RequestParam(value = "postId",required = false) Integer postId,
            @ApiParam(value = "课程id")@RequestParam(value = "id")Integer id,
            @ApiParam(value = "分页参数:页码")@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
            @ApiParam(value = "分页参数:每页数量")@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return trainingCourseClient.findSign(id,name,departCode,partner,workplace,postId,pageNum,pageSize);
    }

    @ApiOperation(value = "培训员工签到",notes = "培训员工签到")
    @PostMapping("staffCourseSign")
    public ComResponse staffCourseSign(@RequestBody @Validated List<SignInputScore> list){
        return  trainingCourseClient.staffCourseSign(list);
    }

    @ApiOperation(value = "培训员工录入成绩",notes = "培训员工录入成绩")
    @PostMapping("staffCourseGrade")
    public ComResponse staffCourseGrade(@RequestBody @Validated List<SignInputScore> list) {
        return trainingCourseClient.staffCourseGrade(list);
    }
    @PostMapping("staffSign")
    public ComResponse staffSign(@RequestBody List<TrainStaffSignPo> list){
        return trainingCourseClient.staffSign(list);
    }

    //@ApiOperation(value = "录入成绩",notes = )


    @ApiOperation(value = "培训员工合格入岗",notes = "培训员工合格入岗")
    @PostMapping("staffEntryPost")
    public ComResponse<Integer> staffEntryPost(TrainStaffRelationPo trainStaffRelationPo){
        return  trainingCourseClient.staffEntryPost(trainStaffRelationPo);
    }

    @ApiOperation(value = "根据类型查询各种状态查询列表",notes = "根据类型查询各种状态查询列表")
    @GetMapping("getPartner")
    public ComResponse<List<Map<String,Object>>> getPartner(@RequestParam("type") String type){
        return trainingCourseClient.getPartner(type);
    }

    @ApiOperation(value = "课件查询",notes = "课件查询")
    @GetMapping("listCourseware")
    public ComResponse<List<CoursewareDto>> listCourseware(
            @ApiParam(value = "课件名称")@RequestParam(value = "name",required = false) String name,
            @ApiParam(value = "分页参数:页码")@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
            @ApiParam(value = "分页参数:每页数量")@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        return trainingCourseClient.listCoursewareDto(name, pageNum, pageSize);
    }

    @ApiOperation(value = "商品列表",notes = "商品列表")
    @GetMapping(value = "productList")
    public ComResponse productList(@ApiParam(value = "编码或名称")@RequestParam(value = "name")String name,@ApiParam(value = "分页页数")@RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,@ApiParam(value = "分页条数")@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        return trainingCourseClient.productList(name,pageNo,pageSize);
    }
}
