package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.fegin.conf.AttendRuleFeginService;
import cn.net.yzl.ehr.service.AttendRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendRuleServiceImpl implements AttendRuleService {
    @Autowired
    private AttendRuleFeginService attendRuleFeginService;

    @Override
    public ComResponse<Integer> update(DepartAttendRuleDto departAttendRuleDto) {



        return attendRuleFeginService.update(departAttendRuleDto);
    }

    @Override
    public ComResponse<Integer> add(DepartAttendRuleDto departAttendRuleDto) {


        Byte type = departAttendRuleDto.getType();

        ComResponse<Integer> result = checkParam(departAttendRuleDto,type);

        if(result.getData()==0){
            return result;
        }



        return attendRuleFeginService.add(departAttendRuleDto);
    }

    private ComResponse<Integer> checkParam(DepartAttendRuleDto departAttendRuleDto, Byte type) {


        if(type==1){   // 定时打卡-正常

        }else if(type==2){  // 定时打卡-可抢

        }else if(type==3){  // 弹性打卡

        }else if(type==4){  // 不打卡
        return ComResponse.success(1);
        }
        return null;
    }

    @Override
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(Integer departId, Integer pageNo, Integer pageSize) {
        return attendRuleFeginService.getByDepartId(departId,pageNo,pageSize);
    }
}
