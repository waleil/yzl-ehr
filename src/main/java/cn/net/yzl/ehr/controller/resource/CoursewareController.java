package cn.net.yzl.ehr.controller.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.ehr.service.resource.CoursewareService;
import cn.net.yzl.staff.pojo.courseWare.CourseSelectPo;
import cn.net.yzl.staff.pojo.courseWare.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.courseWare.CourseWarePo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


import java.util.List;

@RestController
@RequestMapping("/courseware")
@Api(value="培训课件管理",tags = {"公共资源管理"})
public class CoursewareController {

    @Autowired
    private CoursewareService courseWareService;

    @ApiOperation(value = "新增课件", notes = "新增课件", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertcourse", method = RequestMethod.POST)
    ComResponse<Integer> insertCourseWare(@RequestBody CourseWarePo courseWarePo,@ApiIgnore @CurrentStaffNo String creator) {
        return courseWareService.insertCourseWare(courseWarePo,creator);
    }

    @ApiOperation(value = "编辑课件", notes = "编辑课件", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatecourse", method = RequestMethod.POST)
    ComResponse<Integer> updateCourseWare(@RequestBody CourseWarePo courseWarePo,@ApiIgnore @CurrentStaffNo String updator) {
        return courseWareService.updateCourseWare(courseWarePo,updator);
    }

    @ApiOperation(value = "查看课件详情", notes = "查看课件详情")
    @RequestMapping(value = "/selectcourseitem", method = RequestMethod.GET)
    ComResponse<CourseWarePo> selectcourseitem(@RequestParam Integer id) {
        return courseWareService.selectCourseWareByPrimaryKey(id);
    }


    //这里还得做个分页查询、
    //包括模糊查询以及无条件查询
    @ApiOperation(value = "查询课件", notes = "查询课件")
    @RequestMapping(value = "/searchcourse", method = RequestMethod.POST)
    ComResponse<Page<CourseWarePo>> searchCourseWare(@RequestBody CourseSelectPo courseSelectPo) {
        if(StringUtils.isEmpty(courseSelectPo.getKeyword())&&StringUtils.isEmpty(courseSelectPo.getKeyword())){
            return courseWareService.searchCourseWare(courseSelectPo.getPageNum(),courseSelectPo.getPageSize());
        }else{
            return courseWareService.selectKeywordByName(courseSelectPo);
        }
    }

    @ApiOperation(value = "查询课件类型", notes = "查询课件类型")
    @RequestMapping(value = "/selectCourseWareCategory", method = RequestMethod.GET)
    public ComResponse<List<CourseWareCategoryDto>> selectCourseWareCategory() {
        return courseWareService.selectCourseWareCategoryAll();
    }

    @ApiOperation(value = "新增/编辑课件类型", notes = "新增/编辑课件类型", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/savecoursecategory", method = RequestMethod.POST)
    public ComResponse<Integer> save(@RequestBody(required = false) List<CourseWareCategoryPo> list, @ApiIgnore @CurrentStaffNo String staffNo) {
        return courseWareService.saveCourseWareCategory(list,staffNo);
    }



}
