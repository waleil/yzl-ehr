package cn.net.yzl.ehr.service;

import cn.net.yzl.ehr.pojo.SysDict;

import java.util.List;

public interface SysDictService {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    public SysDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    public List<SysDict> selectByType(String Type);


}
