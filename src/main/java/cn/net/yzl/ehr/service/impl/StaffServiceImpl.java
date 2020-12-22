package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.config.annotation.ReadDataSource;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.mapper.StaffMapper;
import cn.net.yzl.ehr.pojo.StaffPo;
import cn.net.yzl.ehr.service.StaffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private StaffFeginService staffFeginService;

    @ReadDataSource
    @Override
    public PageInfo<StaffPo> getPage(int pageNum, int pageSize){
        Page<StaffPo> page = PageHelper.startPage(pageNum, pageSize);
        //PageHelper会自动拦截到下面这查询sql
        this.staffMapper.getAll();
        return page.toPageInfo();
    }

    @Override
    public Object getByPrimaryKey(int id) {
        return staffMapper.selectByPrimaryKey(id);
    }

    @Override
    public ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo) {
        return staffFeginService.getDetailsByNo(staffNo);
    }

}
