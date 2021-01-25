package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.ehr.fegin.temp.CourseWareFeginService;
import cn.net.yzl.ehr.mapper.CoursewareCategoryDictMapper;
import cn.net.yzl.ehr.service.CoursewareCategoryDictService;
import cn.net.yzl.ehr.vojo.UpdateCoursewareCategoryParam;
import cn.net.yzl.staff.pojo.CourseWareCategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoursewareCategoryDictServiceImpl implements CoursewareCategoryDictService {
    @Autowired
    private CourseWareFeginService courseWareFeginService;

//    @Override
//    public ComResponse<List<CourseWareCategoryDto>> getCoursewareCategoryByPage() {
//        ComResponse<List<CourseWareCategoryDto>> comResponse = courseWareFeginService.selectCourseWareCategory();
//        if(comResponse==null){
//            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
//        }else if(comResponse.getCode()==200 && comResponse.getData().size()>0){
//            ComResponse.success();
//        }
//        return comResponse;
//    }
//
//    @Transactional
//    @Override
//    public ComResponse<Integer> saveCoursewareCategoryList(List<CourseWareCategoryPo> list) {
//        ComResponse<Integer> comResponse = courseWareFeginService.saveCourseWareCategory(list);
//        if(comResponse==null){
//            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
//        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
//            ComResponse.success();
//        }
//        return comResponse;
//    }
    /*@Transactional
    @Override
    public int updateCoursewareCategoryList(List<CoursewareCategoryDictDto> dictList) {
        for(CoursewareCategoryDictDto dictDto:dictList){
            dictDto.setIsDel(null);
            coursewareCategoryDictMapper.updateByPrimaryKeySelective(dictDto);
        }

        return dictList.size();
    }

    @Transactional
    @Override
    public int deleteCoursewareCategoryList(List<CoursewareCategoryDictDto> dictList) {
        dictList.forEach(x-> x.setIsDel(1));
        return coursewareCategoryDictMapper.deleteListByPrimaryKey(dictList);
    }

    @Transactional
    @Override
    public int insertCoursewareCategoryList(List<CoursewareCategoryDictDto> dictList) {
        return coursewareCategoryDictMapper.insertList(dictList);
    }*/


}
