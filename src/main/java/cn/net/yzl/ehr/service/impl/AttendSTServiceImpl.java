package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartAttendStDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.fegin.conf.AttendSTFeginMapper;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.service.AttendSTService;
import cn.net.yzl.ehr.vo.DepartAttendStVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendSTServiceImpl implements AttendSTService {
    @Autowired
    private DepartFeginService departFeginMapper;
    @Autowired
    private AttendSTFeginMapper attendSTFeginMapper;
    @Override
    public ComResponse<Integer> add(DepartAttendStVO departAttendStVO) {
        Integer departId = departAttendStVO.getDepartId();
        ComResponse<DepartDto> departByNo = departFeginMapper.getById(departId);

        if (departByNo.getData() == null) {
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(), ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }
        ComResponse<Integer> result = attendSTFeginMapper.add(departAttendStVO);
        if (result.getData() > 0) {
            return ComResponse.success();
        } else {
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(), ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }

    }

    @Override
    public ComResponse<Integer> update(DepartAttendStVO departAttendStVO) {
        Integer departId = departAttendStVO.getDepartId();
        ComResponse<DepartDto> departByNo = departFeginMapper.getById(departId);

        if (departByNo.getData() == null) {
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(), ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }
        ComResponse<Integer> result = attendSTFeginMapper.update(departAttendStVO);
        if (result.getData() > 0) {
            return ComResponse.success();
        } else {
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(), ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }

    }

    @Override
    public ComResponse<DepartAttendStDto> getByDepartId(Integer departId) {
        ComResponse<DepartAttendStDto> result = attendSTFeginMapper.getByDepartId(departId);
        if(result.getData()==null ){
            return ComResponse.nodata();
        }
        return result;
    }
}
