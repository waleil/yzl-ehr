package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeInfoDto;
import cn.net.yzl.ehr.vo.DepartResumeInfoVO;
import cn.net.yzl.ehr.vo.DepartResumeUpdateVO;

import java.util.List;


public interface DepartResumeService {
    ComResponse<List<DepartResumeInfoDto>> getByDepartId(Integer departId);

    ComResponse<Integer> add(DepartResumeInfoVO departResumeInfoVO,String staffNo);


    ComResponse<Integer> update(DepartResumeUpdateVO departResumeUpdateVO);
}
