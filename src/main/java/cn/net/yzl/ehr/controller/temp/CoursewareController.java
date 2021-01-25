package cn.net.yzl.ehr.controller.temp;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.service.CoursewareCategoryDictService;
import cn.net.yzl.ehr.service.CoursewareService;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;
import cn.net.yzl.staff.pojo.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.CourseWarePo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/courseware")
@Api(value="课件接口",tags = {"课件接口"})
public class CoursewareController {

    @Autowired
    private CoursewareService courseWareService;

    @ApiOperation(value = "新增课件", notes = "新增课件", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertcourse", method = RequestMethod.POST)
    ComResponse<Integer> insertCourseWare(@RequestBody CourseWarePo courseWarePo) {
        return courseWareService.insertCourseWare(courseWarePo);
    }

    @ApiOperation(value = "编辑课件", notes = "编辑课件", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatecourse", method = RequestMethod.POST)
    ComResponse<Integer> updateCourseWare(@RequestBody CourseWarePo courseWarePo) {
        return courseWareService.updateCourseWare(courseWarePo);
    }

    @ApiOperation(value = "查看课件详情", notes = "查看课件详情")
    @RequestMapping(value = "/selectcourseitem", method = RequestMethod.GET)
    ComResponse<CourseWarePo> selectcourseitem(@RequestParam Integer id) {
        return courseWareService.selectCourseWareByPrimaryKey(id);
    }


    //这里还得做个分页查询、
    //包括模糊查询以及无条件查询
    @ApiOperation(value = "查询课件", notes = "查询课件")
    @RequestMapping(value = "/searchcourse", method = RequestMethod.GET)
    ComResponse<Page<CourseWarePo>> searchCourseWare(@RequestParam (value = "keyword",required = false)String keyword, @RequestParam (value = "pageNum")Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        if(StringUtils.isEmpty(keyword)){
            return courseWareService.selectCourseAll(pageNum,pageSize);
        }else{
            return courseWareService.selectKeyword(keyword,pageNum,pageSize);
        }
    }

    @ApiOperation(value = "查询课件类型", notes = "查询课件类型")
    @RequestMapping(value = "/selectCourseWareCategory", method = RequestMethod.GET)
    public ComResponse<List<CourseWareCategoryDto>> selectCourseWareCategory() {
        return courseWareService.selectCourseWareCategoryAll();
    }

    @ApiOperation(value = "新增/编辑课件类型", notes = "新增/编辑课件类型", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/savecoursecategory", method = RequestMethod.POST)
    public ComResponse<Integer> save(@RequestBody(required = false) List<CourseWareCategoryPo> list) {
        return courseWareService.saveCourseWareCategory(list);
    }



}
