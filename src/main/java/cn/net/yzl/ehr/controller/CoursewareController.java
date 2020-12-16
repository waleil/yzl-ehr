package cn.net.yzl.ehr.controller;



import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.service.CoursewareService;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/courseware")
@Api(value="课件接口",tags = {"课件接口"})
public class CoursewareController {
    @Autowired
    private CoursewareService coursewareService;

    /**
     * 新增课件 APPLICATION_JSON_VALUE
     * @param courseware
     * @return @RequestBody
     */
    @ApiOperation(value="新增课件",notes="新增课件",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertCourseware", method = RequestMethod.POST)
    int insertCourseware(@RequestBody Courseware courseware){
      return coursewareService.insertCourseware(courseware);
    }
    /**
     * 更改课件
     * @param record
     * @return
     */
    @ApiOperation(value="更改课件",notes="更改课件",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateCourseware", method = RequestMethod.POST)
    int updateCourseware(@RequestBody Courseware record){
        return coursewareService.updateCourseware(record);
    }

    /**
     * 查看课件详情
     * @param id
     * @return
     */
    @ApiOperation(value="查询课件详情",notes="查询课件详情",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name="id",value="id",required=true,dataType="String",paramType="query")
    )
    @RequestMapping(value = "/getCoursewareById", method = RequestMethod.GET)
    ComResponse<CoursewareDto> getCoursewareById(Integer id){
      CoursewareDto coursewareDto=  coursewareService.getCoursewareById(id);
        if (coursewareDto != null) {
            return ComResponse.success(coursewareDto);
        } else {
            return ComResponse.nodata();
        }
    }

    /**
     * 分页查询课件
     * @param param
     * @return
     */
    @ApiOperation(value="查询课件列表",notes="查询课件列表",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequestMapping(value = "/getCoursewareByPage", method = RequestMethod.GET)
    List<CoursewareDto> getCoursewareByPage(QueryCoursewareParam param){
        return coursewareService.getCoursewareByPage(param);
    }
    /**
     * 更改课件状态
     * @param record
     * @return
     */
    @ApiOperation(value="审核课件",notes="审核课件",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStatusById", method = RequestMethod.POST)
    int updateStatusById(Courseware record){
        return coursewareService.updateStatusById(record);
    }
    /**
     * 批量更改课件状态
     * @param coursewareList
     * @return
     */
    @ApiOperation(value="批量审核课件",notes="批量审核课件",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStatusByList", method = RequestMethod.POST)
    int updateStatusByList(@RequestBody List<Courseware> coursewareList){
        return coursewareService.updateStatusByList(coursewareList);
    }

    /**
     * 根据课件编号删除课件
     * @param coursewareId
     * @return
     */
    @ApiOperation(value="删除课件",notes="删除课件",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name="coursewareId",value="coursewareId",required=true,dataType="int",paramType="query"),
    })
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    int deleteByPrimaryKey(int coursewareId){
        return coursewareService.deleteByPrimaryKey(coursewareId);
    }




}
