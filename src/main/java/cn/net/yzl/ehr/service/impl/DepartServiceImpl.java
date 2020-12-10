package cn.net.yzl.ehr.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.service.DepartService;
import cn.net.yzl.ehr.vo.DepartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartFeginService departFeginService;

    @Override
    public ComResponse<DepartDto> getTreeList() {
        return departFeginService.getTreeList();
    }

    @Override
    public ComResponse<String> add(DepartVO departVO) {

        return departFeginService.add(departVO);
    }

    @Override
    public ComResponse<String> update(DepartVO departVO) {
        return departFeginService.update(departVO);
    }

    @Override
    public ComResponse<String> del(String departId) {
        return departFeginService.del(departId);
    }

    @Override
    public ComResponse<DepartDto> getByUserNo(String userNo) {
        if(StrUtil.isBlank(userNo)){
            return ComResponse.fail(ResponseCodeEnums.PARAMS_EMPTY_ERROR_CODE.getCode(),ResponseCodeEnums.PARAMS_EMPTY_ERROR_CODE.getMessage());
        }

        return departFeginService.getByUserNo(userNo);
    }
}
