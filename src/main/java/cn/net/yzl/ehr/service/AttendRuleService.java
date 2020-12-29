package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.PostDto;

import java.util.Date;
import java.util.List;


public interface AttendRuleService {
    ComResponse<Integer> update(DepartAttendRuleDto departAttendRuleDto);

    ComResponse<Integer> addOrUpdate(List<DepartAttendRuleDto> departAttendRuleDto,String staffNo);


    ComResponse<Page<DepartAttendRuleDto>> getByDepartIdAndTime(Integer departId, Integer pageNo, Integer pageSize, String time);


    ComResponse<DepartAttendRuleDto> getByParams(Integer departId, String time, Integer postId, Integer typeId);


    ComResponse<List<PostDto>> getPostList(Integer departId);
}
