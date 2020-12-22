package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.CoursewareCategoryDictDto;
import cn.net.yzl.ehr.dto.CoursewareDto;
import cn.net.yzl.ehr.pojo.Courseware;
import cn.net.yzl.ehr.vojo.QueryCoursewareParam;

import java.util.List;
import java.util.Map;

public interface CoursewareService {
    /**
     * 新增课件
     * @param courseware
     * @return
     */
    int insertCourseware(Courseware courseware);
    /**
     * 更改课件
     * @param record
     * @return
     */
    int updateCourseware(Courseware record);
    /**
     * 查看课件详情
     * @param id
     * @return
     */
    CoursewareDto getCoursewareById(Integer id);
    /**
     * 分页查询课件
     * @param param
     * @return
     */
    Page<CoursewareDto> getCoursewareByPage(QueryCoursewareParam param);
    /**
     * 更改课件审批状态
     * @param record
     * @return
     */
    int updateStatusById(Courseware record);
    /**
     * 批量更改课件状态
     * @param courseware
     * @return
     */
    int updateStatusByList(List<Courseware> courseware);
    /**
     * 删除课件
     * @param coursewareId
     * @return
     */
    public int deleteByPrimaryKey(int coursewareId);
    

}
