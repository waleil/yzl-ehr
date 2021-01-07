package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.conf.AttendRuleFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.fegin.post.PostFeginMapper;
import cn.net.yzl.ehr.service.AttendRuleService;
import cn.net.yzl.ehr.vo.attendRule.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AttendRuleServiceImpl implements AttendRuleService {
    @Autowired
    private AttendRuleFeginService attendRuleFeginService;


    @Override
    public ComResponse<List<DepartPostDto>> getPostList(Integer departId) {
        return attendRuleFeginService.getPostList(departId);
    }

    @Override
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(Integer departId, Integer pageNo, Integer pageSize) throws ParseException {
        return attendRuleFeginService.getByDepartId(departId,pageNo,pageSize);
    }

    @Override
    public ComResponse<DepartAttendRuleDto> getByDepartIdAndPostIdAndEnable(Integer departId, Integer postId, Integer enable) {
        return attendRuleFeginService.getByDepartIdAndPostIdAndEnable(departId,postId,enable);
    }

    @Override
    public ComResponse<Integer> addOrUpdateNormal(DepartAttendRuleNormalVO departAttendRuleNormalVO) {
        return attendRuleFeginService.addOrUpdateNormal(departAttendRuleNormalVO);
    }

    @Override
    public ComResponse<Integer> addOrUpdateRobbed(DepartAttendRuleRobbedVO departAttendRuleRobbedVO) {
        return attendRuleFeginService.addOrUpdateRobbed(departAttendRuleRobbedVO);
    }

    @Override
    public ComResponse<Integer> addOrUpdateElastic(DepartAttendRuleElasticVO departAttendRuleElasticVO) {
        return attendRuleFeginService.addOrUpdateElastic(departAttendRuleElasticVO);
    }

    @Override
    public ComResponse<Integer> addOrUpdatePunch(DepartAttendRuleNoPunchVO departAttendRuleNoPunchVO) {
        return attendRuleFeginService.addOrUpdatePunch(departAttendRuleNoPunchVO);
    }


}
