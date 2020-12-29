package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.AttendFalsePunishDto;
import cn.net.yzl.ehr.pojo.AttendFalsePunishPo;


import java.util.List;

public interface AttendFalsePunishService {

    ComResponse<Integer> add(AttendFalsePunishPo attendFalsePunishPo);


    ComResponse<List<AttendFalsePunishDto>> getPunishList();
}
