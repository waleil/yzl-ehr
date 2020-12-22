package cn.net.yzl.ehr.vojo;

import cn.net.yzl.ehr.dto.CoursewareCategoryDictDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCoursewareCategoryParam {
    private List<CoursewareCategoryDictDto> insertList;
    private List<CoursewareCategoryDictDto> updateList;
    private List<CoursewareCategoryDictDto> deleteList;


}
