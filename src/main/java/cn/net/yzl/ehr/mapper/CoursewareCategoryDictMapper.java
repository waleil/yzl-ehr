package cn.net.yzl.ehr.mapper;



import cn.net.yzl.staff.pojo.CourseWareCategoryPo;

import java.util.List;

public interface CoursewareCategoryDictMapper {

    List<CourseWareCategoryPo> selectList();

    int insertList(List<CourseWareCategoryPo> dictList);

    int insert(CourseWareCategoryPo dictDto);

    int updateByPrimaryKeySelective(CourseWareCategoryPo dictDto);

}