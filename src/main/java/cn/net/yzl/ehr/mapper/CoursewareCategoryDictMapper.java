package cn.net.yzl.ehr.mapper;


import cn.net.yzl.ehr.dto.CoursewareCategoryDictDto;

import java.util.List;

public interface CoursewareCategoryDictMapper {

    List<CoursewareCategoryDictDto> selectList();

    int insertList(List<CoursewareCategoryDictDto> dictList);

    int insert(CoursewareCategoryDictDto dictDto);

    int updateByPrimaryKeySelective(CoursewareCategoryDictDto dictDto);

}