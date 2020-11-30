package cn.net.yzl.ehr.service;

import cn.net.yzl.ehr.pojo.StaffPo;
import com.github.pagehelper.PageInfo;

public interface StaffService {


    public PageInfo<StaffPo> getPage(int pageNum, int pageSize);

    Object getByPrimaryKey(int id);
}
