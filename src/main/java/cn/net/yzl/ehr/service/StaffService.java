package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.pojo.StaffPo;
import com.github.pagehelper.PageInfo;

public interface StaffService {


    public PageInfo<StaffPo> getPage(int pageNum, int pageSize);

    Object getByPrimaryKey(int id);

    // 获取用户详情
    ComResponse<StaffDetailsDto> getDetailsByNo(Integer userNo);
}
