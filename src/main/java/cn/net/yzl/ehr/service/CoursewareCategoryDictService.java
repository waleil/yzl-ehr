package cn.net.yzl.ehr.service;

import cn.net.yzl.ehr.dto.CoursewareCategoryDictDto;
import cn.net.yzl.ehr.vojo.UpdateCoursewareCategoryParam;

import java.util.List;

public interface CoursewareCategoryDictService {

    /**
     * 查询课件列表
     * @return
     */
    List<CoursewareCategoryDictDto> getCoursewareCategoryByPage();

    int updateCoursewareCategoryList(UpdateCoursewareCategoryParam param);

    /**
     * 更改课件列表
     * @return
     */
  //  int updateCoursewareCategoryList(List<CoursewareCategoryDictDto> dictList);

    /**
     * 删除课件列表
     * @return
     */
  //  int deleteCoursewareCategoryList(List<CoursewareCategoryDictDto> dictList);

    /**
     * 新增课件列表
     * @return
     */
  //  int insertCoursewareCategoryList(List<CoursewareCategoryDictDto> dictList);

}
