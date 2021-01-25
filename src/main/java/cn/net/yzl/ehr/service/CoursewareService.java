package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;
import cn.net.yzl.staff.pojo.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.CourseWarePo;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface CoursewareService {

    //添加课程
    ComResponse<Integer>  insertCourseWare(CourseWarePo courseWarePo);
    //更新课程
    ComResponse<Integer> updateCourseWare(CourseWarePo courseWarePo);
    //根据id查询编号
    ComResponse<CourseWarePo> selectCourseWareByPrimaryKey(Integer id);
    //查询课件
    ComResponse<Page<CourseWarePo>> searchCourseWare(Integer pageNum, Integer pageSize);
    //模糊查询
    ComResponse<Page<CourseWarePo>> selectKeywordByName(String Keyword, Integer pageNum, Integer pageSize);

    //查询所有的课程类型
    ComResponse<List<CourseWareCategoryDto>>  selectCourseWareCategoryAll();

    //保存课程类型数据
    ComResponse<Integer> saveCourseWareCategory(List<CourseWareCategoryPo> list);
    

}
