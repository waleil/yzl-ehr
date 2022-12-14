package cn.net.yzl.ehr.service.impl.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.ehr.fegin.resource.CourseWareFeginService;
import cn.net.yzl.ehr.service.resource.CoursewareService;
import cn.net.yzl.staff.pojo.courseWare.CourseSelectPo;
import cn.net.yzl.staff.pojo.courseWare.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.courseWare.CourseWarePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    private CourseWareFeginService courseWareFeginService;
    @Override
    public ComResponse<Integer> insertCourseWare(CourseWarePo courseWarePo, String creator) {
        courseWarePo.setCreator(creator);
        courseWarePo.setUpdator(creator);
        return courseWareFeginService.insertCourseWare(courseWarePo);
    }

    @Override
    public ComResponse<Integer> updateCourseWare(CourseWarePo courseWarePo,String updator) {
        courseWarePo.setUpdator(updator);
        return courseWareFeginService.updateCourseWare(courseWarePo);
    }

    @Override
    public ComResponse<CourseWarePo> selectCourseWareByPrimaryKey(Integer id) {
        return courseWareFeginService.selectcourseitem(id);
    }

    @Override
    public ComResponse<Page<CourseWarePo>> searchCourseWare(Integer pageNum, Integer pageSize) {
        return courseWareFeginService.searchCourseWare(pageNum,pageSize);
    }

    @Override
    public ComResponse<Page<CourseWarePo>> selectKeywordByName(CourseSelectPo courseSelectPo) {
        return courseWareFeginService.searchCourseWareByName(courseSelectPo);
    }


    @Override
    public ComResponse<List<CourseWareCategoryDto>> selectCourseWareCategoryAll() {
        return courseWareFeginService.selectCourseWareCategory();
    }

    @Override
    public ComResponse<Integer> saveCourseWareCategory(List<CourseWareCategoryPo> list, String staffNo) {
        for (CourseWareCategoryPo courseWareCategoryPo : list) {
            if(courseWareCategoryPo.getId()==null||courseWareCategoryPo.getId()==0){
                courseWareCategoryPo.setCreator(staffNo);
            }else {
                courseWareCategoryPo.setUpdator(staffNo);
            }
        }
        return courseWareFeginService.saveCourseWareCategory(list);
    }
}
