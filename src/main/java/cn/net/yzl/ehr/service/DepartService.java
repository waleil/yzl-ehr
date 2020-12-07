package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;

public interface DepartService {
    ComResponse<DepartDto> getTreeList();


}
