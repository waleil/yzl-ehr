package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.pojo.DepartResumeItemPo;
import cn.net.yzl.ehr.pojo.DepartResumePo;


import java.util.List;


public interface DepartResumeService {

    ComResponse<List<DepartResumeDto>> getByDepartId(Integer departId);

    ComResponse<String> add(DepartResumePo departResumePo, String staffNo);

    ComResponse<DepartResumeDto> getByPostId(Integer departId, Integer postId);

    ComResponse<DepartResumeDto> getByResumeId(Integer resumeId);

    ComResponse<String> update(DepartResumeItemPo departResumeItemPo, String staffNo);

    ComResponse<String> deleteByResumeId(Integer resumeId, String updator);


}
