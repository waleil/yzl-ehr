package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.vo.DepartVO;

public interface DepartService {
    ComResponse<DepartDto> getTreeList();

    // 添加部门
    ComResponse<String> add(DepartVO departVO);

    // 更新部门
    ComResponse<String> update(DepartVO departVO);
    // 删除部门
    ComResponse<String> del(String departId);
}
