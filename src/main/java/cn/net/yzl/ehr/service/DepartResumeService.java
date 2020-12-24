package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.PostBaseDto;
import cn.net.yzl.ehr.vo.DepartResumeUpdateVO;
import cn.net.yzl.ehr.vo.DepartResumeVO;

import java.util.List;
import java.util.Map;


public interface DepartResumeService {
    ComResponse<Map<PostBaseDto, List<DepartResumeDto>>> getByDepartId(Integer departId);

    ComResponse<Integer> add(DepartResumeVO departResumeVO);

    ComResponse<Integer> update(DepartResumeUpdateVO departResumeUpdateVO);
}
