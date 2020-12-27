package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.ehr.mapper.SysDictMapper;
import cn.net.yzl.ehr.pojo.SysDict;
import cn.net.yzl.ehr.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysDictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysDict record) {
        return sysDictMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDict record) {
        return sysDictMapper.insertSelective(record);
    }

    @Override
    public SysDict selectByPrimaryKey(Integer id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDict record) {
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDict record) {
        return sysDictMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysDict> selectByType(String type) {
        return sysDictMapper.selectByType(type);
    }

}
