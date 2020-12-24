package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;

import java.util.List;

public interface DepartService {
    ComResponse<DepartDto> getTreeList();

    // 添加部门
    ComResponse<String> add(DepartVO departVO);

    // 更新部门
    ComResponse<String> update(DepartUpdateVO departVO);
    // 删除部门
    ComResponse<String> del(Integer departId);


    ComResponse<DepartDto> getByUserNo(String userNo);

    ComResponse<List<DepartDto>> getChildById(Integer id);


    ComResponse<List<DepartDto>> getChildByLevel(Integer level);
}
