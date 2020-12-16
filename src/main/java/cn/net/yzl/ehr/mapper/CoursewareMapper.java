package cn.net.yzl.ehr.mapper;


import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.pojo.CoursewareCategory;
import cn.net.yzl.ehr.pojo.CoursewareDepart;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursewareMapper   {
    /**
     * 新增课件部门关联数据
     * @param departList
     * @return
     */
    int insertCoursewareDepartSelective(@Param("departList") List<CoursewareDepart> departList);

    /**
     * 新增课件类别关联数据
     * @param categoryList
     * @return
     */
    int insertCoursewareCategorySelective(@Param("categoryList") List<CoursewareCategory> categoryList);
    /**
     * 新增课件
     * @param record
     * @return
     */
    int insertCoursewareSelective(Courseware record);
    /**
     * 查看课件详情
     * @param id
     * @return
     */
    CoursewareDto selectByPrimaryKey(Integer id);
    /**
     * 分页查看课件
     * @param param
     * @return
     */
    List<CoursewareDto> selectListByPage(QueryCoursewareParam param);
    /**
     * 更改课件信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Courseware record);
    /**
     * 单项更改课件状态
     * @param courseware
     * @return
     */
    int updateStateByCoursewareId(Courseware courseware);

    /**
     * 更改单个课件的所有科室开放关系状态
     * @param depart
     * @return
     */
    int updateDepartStateByCoursewareId(CoursewareDepart depart);

    /**
     * 更改单个课件的所有课件类型关系状态
     * @param category
     * @return
     */
    int updateCategoryStateByCoursewareId(CoursewareCategory category);


    int deleteByPrimaryKey(int coursewareId);
}