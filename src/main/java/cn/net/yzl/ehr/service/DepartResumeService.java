package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeItemDto;
import cn.net.yzl.ehr.pojo.DepartResumeInsertListPo;


public interface DepartResumeService {

    ComResponse<String> add(DepartResumeInsertListPo departResumePo) ;

    ComResponse<Integer> saveUpdate(DepartResumeInsertListPo itemUpdatePo);

    ComResponse<Page<DepartResumeItemDto>> getByDepartId(Integer departId, Integer pageNo,
                                                         Integer pageSize);

    ComResponse<DepartResumeDto> getByPostId( Integer departId,  Integer postId) ;

    ComResponse<DepartResumeDto> getByResumeId(Integer resumeId) ;

    ComResponse<Integer> deleteByResumeId(Integer resumeId, String updator);

}
