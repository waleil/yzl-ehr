package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.ehr.dto.CoursewareCategoryDictDto;
import cn.net.yzl.ehr.mapper.CoursewareCategoryDictMapper;
import cn.net.yzl.ehr.service.CoursewareCategoryDictService;
import cn.net.yzl.ehr.vojo.UpdateCoursewareCategoryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoursewareCategoryDictServiceImpl implements CoursewareCategoryDictService {
    @Autowired
    CoursewareCategoryDictMapper coursewareCategoryDictMapper;

    @Override
    public List<CoursewareCategoryDictDto> getCoursewareCategoryByPage() {
        return  coursewareCategoryDictMapper.selectList();
    }

    @Transactional
    @Override
    public int updateCoursewareCategoryList(UpdateCoursewareCategoryParam param) {
        List<CoursewareCategoryDictDto> insertList=param.getInsertList();
        List<CoursewareCategoryDictDto> updateList=param.getUpdateList();
        List<CoursewareCategoryDictDto> deleteList=param.getDeleteList();
        int num=insertList.size()+updateList.size()+deleteList.size();
        if(num>0){
        //删除

        for(CoursewareCategoryDictDto dictDto:deleteList){
            dictDto.setIsDel(1);
            dictDto.setName(null);
            num-= coursewareCategoryDictMapper.updateByPrimaryKeySelective(dictDto);
        }

        //更改
        for(CoursewareCategoryDictDto dictDto:updateList){
            dictDto.setIsDel(null);
            num-= coursewareCategoryDictMapper.updateByPrimaryKeySelective(dictDto);
        }
        //新增
            for(CoursewareCategoryDictDto dictDto:insertList){
                num-= coursewareCategoryDictMapper.insert(dictDto);
            }
        //num-=coursewareCategoryDictMapper.insertList(insertList);
        if(num!=0){
            return 1;
        }
        }
        return 0;
    }
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
