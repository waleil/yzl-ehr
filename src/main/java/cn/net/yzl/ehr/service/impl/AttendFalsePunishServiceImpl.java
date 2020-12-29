package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;

import cn.net.yzl.ehr.dto.AttendFalsePunishDto;
import cn.net.yzl.ehr.fegin.departAttend.AttendFalsePunishFeginService;
import cn.net.yzl.ehr.pojo.AttendFalsePunishPo;
import cn.net.yzl.ehr.service.AttendFalsePunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendFalsePunishServiceImpl implements AttendFalsePunishService {

    @Autowired
    private AttendFalsePunishFeginService attendFalsePunishFeginService;

    @Override
    public ComResponse<Integer> add(AttendFalsePunishPo attendFalsePunishPo) {
        return  attendFalsePunishFeginService.add(attendFalsePunishPo);
    }

    @Override
    public ComResponse<List<AttendFalsePunishDto>> getPunishList() {
        return attendFalsePunishFeginService.getPunishList();
    }

}
