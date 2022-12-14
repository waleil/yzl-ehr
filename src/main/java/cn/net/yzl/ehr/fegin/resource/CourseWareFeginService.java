package cn.net.yzl.ehr.fegin.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.staff.pojo.courseWare.CourseSelectPo;
import cn.net.yzl.staff.pojo.courseWare.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.courseWare.CourseWarePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface CourseWareFeginService {

    @ApiOperation(value = "新增课件", notes = "新增课件", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/trainCourseWare/insertcourse", method = RequestMethod.POST)
    ComResponse<Integer> insertCourseWare(@RequestBody CourseWarePo courseWarePo);

    @ApiOperation(value = "编辑课件", notes = "编辑课件", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/trainCourseWare/updatecourse", method = RequestMethod.POST)
    ComResponse<Integer> updateCourseWare(@RequestBody CourseWarePo courseWarePo);

    @ApiOperation(value = "查看课件详情", notes = "查看课件详情")
    @RequestMapping(value = "/trainCourseWare/selectcourseitem", method = RequestMethod.GET)
    ComResponse<CourseWarePo> selectcourseitem(@RequestParam("id") Integer id);

    @ApiOperation(value = "查询课件", notes = "查询课件")
    @RequestMapping(value = "/trainCourseWare/searchcourse", method = RequestMethod.POST)
    ComResponse<Page<CourseWarePo>> searchCourseWare(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize);

    @ApiOperation(value = "根据课件名模糊查询课件", notes = "根据课件名模糊查询课件")
    @RequestMapping(value = "/trainCourseWare/searchcourseByName", method = RequestMethod.POST)
    ComResponse<Page<CourseWarePo>> searchCourseWareByName(@RequestBody CourseSelectPo courseSelectPo);

    @ApiOperation(value = "查询课件类型", notes = "查询课件类型")
    @RequestMapping(value = "/trainCourseWare/selectCourseWareCategory", method = RequestMethod.GET)
    public ComResponse<List<CourseWareCategoryDto>> selectCourseWareCategory();

    @ApiOperation(value = "新增/编辑课件类型", notes = "新增/编辑课件类型", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/trainCourseWare/savecoursecategory", method = RequestMethod.POST)
    public ComResponse<Integer> saveCourseWareCategory(@RequestBody(required = false) List<CourseWareCategoryPo> list);

}
