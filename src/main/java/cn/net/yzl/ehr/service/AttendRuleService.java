package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.vo.attendRule.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface AttendRuleService {
    ComResponse<List<DepartPostDto>> getPostList(Integer departId);

    // 获取部门下的考勤规则
    ComResponse<Page<DepartAttendRuleDto>> getByDepartId(Integer departId, Integer pageNo, Integer pageSize) throws ParseException;

    ComResponse<Integer> addOrUpdateNormal(DepartAttendRuleNormalVO departAttendRuleNormalVO,String staffNo);

    ComResponse<Integer> addOrUpdateRobbed(DepartAttendRuleRobbedVO departAttendRuleRobbedVO,String staffNo);

    ComResponse<Integer> addOrUpdateElastic(DepartAttendRuleElasticVO departAttendRuleElasticVO,String staffNo);

    ComResponse<Integer> addOrUpdatePunch(DepartAttendRuleNoPunchVO departAttendRuleNoPunchVO,String staffNo);

    ComResponse<DepartAttendRuleDto> getByDepartPostIdAndEnable(Integer departPostId, Integer enable);
}
