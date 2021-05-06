package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttrDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.vo.DepartBusinessAttrVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import cn.net.yzl.staff.dto.StaffBaseDto;

import java.util.List;

public interface DepartService {
    ComResponse<List<DepartDto>> getTreeList();

    // 添加部门
    ComResponse<DepartDto> add(DepartVO departVO);
    // 更新部门
    ComResponse<String> update(DepartUpdateVO departVO);
    // 删除部门
    ComResponse<String> del(Integer departId);
    ComResponse<List<DepartDto>> getChildById(Integer id);
    ComResponse<List<DepartDto>> getChildByLevel(Integer level);
    ComResponse<DepartDto> getById(Integer id);

    ComResponse<Integer> updateSortByIds(List<Integer> ids);


    ComResponse<Integer> addBusinessAtrr(DepartBusinessAttrVO departBusinessAttrVO);

    ComResponse<List<DepartAttrDto>> getDepartAttrList();

    ComResponse<List<cn.net.yzl.staff.dto.DepartDto>> getListByStaffNo(String staffNo);

    ComResponse<List<StaffBaseDto>> getByParamsForLeaderNo(String param, String staffNo);

    ComResponse<List<Integer>> getDepartListByStaffNo(String staffNo);

    ComResponse<List<cn.net.yzl.staff.dto.DepartDto>> getListByStaffNoData(String staffNo,Boolean maxLevel);


}
