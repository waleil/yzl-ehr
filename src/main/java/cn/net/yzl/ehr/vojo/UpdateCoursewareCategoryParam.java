package cn.net.yzl.ehr.vojo;

import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCoursewareCategoryParam {
    private List<CourseWareCategoryDto> insertList;
    private List<CourseWareCategoryDto> updateList;
    private List<CourseWareCategoryDto> deleteList;


}
