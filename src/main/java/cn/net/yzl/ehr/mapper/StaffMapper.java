package cn.net.yzl.ehr.mapper;


import cn.net.yzl.ehr.pojo.StaffPo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StaffMapper {

    public StaffPo selectByPrimaryKey(int id);

    List<StaffPo> getAll();
}