package cn.net.yzl.ehr.mapper;


import cn.net.yzl.ehr.pojo.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    public SysDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    public List<SysDict> selectByType(String type);
}