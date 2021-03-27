package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartAttrDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.service.DepartService;
import cn.net.yzl.ehr.vo.DepartBusinessAttrVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartFeginService departFeginService;

    @Override
    public ComResponse<List<DepartDto>> getTreeList() {
        ComResponse<DepartDto> treeList = departFeginService.getTreeList();

        if(treeList.getData()!=null){
            ArrayList<DepartDto> departDtos = new ArrayList<>();
            departDtos.add(treeList.getData());
            return ComResponse.success(departDtos);
        }


        return ComResponse.nodata();
    }

    @Override
    public ComResponse<DepartDto> add(DepartVO departVO) {

        return departFeginService.add(departVO);
    }

    @Override
    public ComResponse<String> update(DepartUpdateVO departVO) {
        return departFeginService.update(departVO);
    }

    @Override
    public ComResponse<String> del(Integer departId) {
        return departFeginService.del(departId);
    }


    @Override
    public ComResponse<List<DepartDto>> getChildById(Integer id) {

        return departFeginService.getChildById(id);
    }

    @Override
    public ComResponse<List<DepartDto>> getChildByLevel(Integer level) {

        return departFeginService.getChildByLevel(level);
    }

    @Override
    public ComResponse<DepartDto> getById(Integer id) {

        return departFeginService.getById(id);
    }

    @Override
    public ComResponse<Integer> updateSortByIds(List<Integer> ids) {

        return departFeginService.updateSortByIds(ids);
    }

    @Override
    public ComResponse<Integer> addBusinessAtrr(DepartBusinessAttrVO departBusinessAttrVO) {
        return departFeginService.addBusinessAtrr(departBusinessAttrVO);
    }

    @Override
    public ComResponse<List<DepartAttrDto>> getDepartAttrList() {
        return departFeginService.getDepartAttrList();
    }

    @Override
    public ComResponse<List<cn.net.yzl.staff.dto.DepartDto>> getListByStaffNo(String staffNo){
        return departFeginService.getListByStaffNo(staffNo);
    }

    @Override
    public ComResponse<List<Integer>> getDepartListByStaffNo(String staffNo) {
        return departFeginService.getDepartListByStaffNo(staffNo);
    }

}
