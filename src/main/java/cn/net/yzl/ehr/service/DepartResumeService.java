package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeInfoDto;
import cn.net.yzl.ehr.util.ValidList;
import cn.net.yzl.ehr.vo.DepartResumeInfoVO;
import cn.net.yzl.ehr.vo.DepartResumeInsertPo;
import cn.net.yzl.ehr.vo.DepartResumeItemPo;


import java.util.List;


public interface DepartResumeService {

    ComResponse<List<DepartResumeInfoDto>> getByDepartId(Integer departId);

    ComResponse<String> add(DepartResumeInfoVO departResumeInfoVO, String staffNo);

    ComResponse<List<DepartResumeDto>> getByPostId(Integer postId);

    ComResponse<String> update(DepartResumeItemPo departResumeItemPo, String staffNo);

    ComResponse<String> deleteByPostId(Integer postId, String updator);


}
