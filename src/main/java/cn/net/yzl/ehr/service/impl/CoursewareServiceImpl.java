package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.mapper.CoursewareMapper;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.pojo.CoursewareCategory;
import cn.net.yzl.ehr.pojo.CoursewareDepart;
import cn.net.yzl.ehr.service.CoursewareService;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    private CoursewareMapper coursewareMapper;


    @Override
    @Transactional
    public int insertCourseware(Courseware courseware) {
        int j=0;
        int i=coursewareMapper.insertCoursewareSelective(courseware);
        List<CoursewareDepart> departList=courseware.getDepartList();
        List<CoursewareCategory> categoryList = courseware.getCategoryList();
        if(departList!=null && departList.size()>0){
        departList.forEach(x-> {
                    x.setCoursewareId(courseware.getId());
                    x.setCreator(courseware.getCreator());
                }
        );
         j=coursewareMapper.insertCoursewareDepartSelective(departList);
        }
        if (categoryList != null && categoryList.size() > 0) {
            categoryList.forEach(x -> {
                        x.setCoursewareId(courseware.getId());
                        x.setCreator(courseware.getCreator());
                    }
            );
            coursewareMapper.insertCoursewareCategorySelective(categoryList);
        }
        return i;
    }

    @Override
    @Transactional
    public int updateCourseware(Courseware record) {
       int i= coursewareMapper.updateByPrimaryKeySelective(record);
       if(i>0) {
           //目前采取清除旧关系数据，重新生成课件-部门关系数据方式
           CoursewareDepart depart = new CoursewareDepart();
           depart.setCoursewareId(record.getId());
           depart.setIsDel(1);
           CoursewareCategory category=new CoursewareCategory();
           category.setCoursewareId(record.getId());
           category.setIsDel(1);
           coursewareMapper.updateDepartStateByCoursewareId(depart);
           coursewareMapper.updateCategoryStateByCoursewareId(category);
           List<CoursewareDepart> departList = record.getDepartList();
           List<CoursewareCategory> categoryList = record.getCategoryList();
           if (departList != null && departList.size() > 0) {
               departList.forEach(x -> {
                           x.setCoursewareId(record.getId());
                           x.setCreator(record.getCreator());
                       }
               );
               coursewareMapper.insertCoursewareDepartSelective(departList);
           }
           if (categoryList != null && categoryList.size() > 0) {
               categoryList.forEach(x -> {
                           x.setCoursewareId(record.getId());
                           x.setCreator(record.getCreator());
                       }
               );
               coursewareMapper.insertCoursewareCategorySelective(categoryList);
           }
       }
        return i;
    }

    @Override
    public CoursewareDto getCoursewareById(Integer id) {
        CoursewareDto courseware = coursewareMapper.selectByPrimaryKey(id);
        return courseware;
    }

    @Override
    public List<CoursewareDto> getCoursewareByPage(QueryCoursewareParam param) {
        List<CoursewareDto> coursewares = coursewareMapper.selectListByPage(param);
        return coursewares;
    }

    @Override
    public int updateStatusById(Courseware record) {
        int i=coursewareMapper.updateStateByCoursewareId(record);
        return i;
    }

    @Override
    public int updateStatusByList(List<Courseware> coursewareList) {
        for(Courseware courseware:coursewareList){
             coursewareMapper.updateStateByCoursewareId(courseware);
        }
        return coursewareList.size();
    }

    @Override
    public int deleteByPrimaryKey(int coursewareId){
        return coursewareMapper.deleteByPrimaryKey(coursewareId);
    }
}
