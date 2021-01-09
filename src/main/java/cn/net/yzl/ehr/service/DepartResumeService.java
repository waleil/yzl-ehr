package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.pojo.DepartResumeItemPo;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


public interface DepartResumeService {

    ComResponse<String> add(DepartResumePo departResumePo) ;

    ComResponse<Integer> saveUpdate(DepartResumeItemPo itemUpdatePo);

    ComResponse<List<DepartResumeDto>> getByDepartId(Integer departId);

    ComResponse<DepartResumeDto> getByPostId( Integer departId,  Integer postId) ;

    ComResponse<DepartResumeDto> getByResumeId(Integer resumeId) ;

    ComResponse<Integer> deleteByResumeId(Integer resumeId, String updator);

}
