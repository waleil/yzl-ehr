package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeInfoDto;
import cn.net.yzl.ehr.vo.DepartResumeInfoVO;

import java.util.List;


public interface DepartResumeService {
    ComResponse<List<DepartResumeInfoDto>> getByDepartId(Integer departId);

    ComResponse<String> add(DepartResumeInfoVO departResumeInfoVO,String staffNo);

    ComResponse<List<DepartResumeDto>> getByPostId(Integer postId);
    //ComResponse<Integer> update(DepartResumeUpdateVO departResumeUpdateVO);
    ComResponse<String> update(DepartResumeInfoVO departResumeInfoVO,String staffNo);

    ComResponse<String> deleteByPostId(Integer postId);
}
