package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.util.AssemblerResultUtil;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.fegin.temp.CourseWareFeginService;
import cn.net.yzl.ehr.mapper.CoursewareMapper;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.pojo.CoursewareCategory;
import cn.net.yzl.ehr.pojo.CoursewareDepart;
import cn.net.yzl.ehr.service.CoursewareService;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;
import cn.net.yzl.staff.pojo.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.CourseWarePo;
import com.github.pagehelper.PageHelper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    private CourseWareFeginService courseWareFeginService;
    @Override
    public ComResponse<Integer> insertCourseWare(CourseWarePo courseWarePo) {
        return courseWareFeginService.insertCourseWare(courseWarePo);
    }

    @Override
    public ComResponse<Integer> updateCourseWare(CourseWarePo courseWarePo) {
        return courseWareFeginService.updateCourseWare(courseWarePo);
    }

    @Override
    public ComResponse<CourseWarePo> selectCourseWareByPrimaryKey(Integer id) {
        return courseWareFeginService.selectcourseitem(id);
    }

    @Override
    public ComResponse<Page<CourseWarePo>> selectCourseAll(Integer pageNum, Integer pageSize) {
        return courseWareFeginService.searchCourseWare("",pageNum,pageNum);
    }

    @Override
    public ComResponse<Page<CourseWarePo>> selectKeyword(String keyword, Integer pageNum, Integer pageSize) {
        return courseWareFeginService.searchCourseWare(keyword,pageNum,pageSize);
    }

    @Override
    public ComResponse<List<CourseWareCategoryDto>> selectCourseWareCategoryAll() {
        return courseWareFeginService.selectCourseWareCategory();
    }

    @Override
    public ComResponse<Integer> saveCourseWareCategory(List<CourseWareCategoryPo> list) {
        return courseWareFeginService.saveCourseWareCategory(list);
    }
}
