package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.ehr.mapper.OfficeSuppliesChangeRecordMapper;
import cn.net.yzl.ehr.mapper.OfficeSuppliesMapper;
import cn.net.yzl.ehr.pojo.OfficeSupplies;
import cn.net.yzl.ehr.pojo.OfficeSuppliesChangeRecord;
import cn.net.yzl.ehr.service.OfficeSuppliesService;
import cn.net.yzl.ehr.vojo.OfficeSuppliesChangeRecordPageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeSuppliesServiceImpl implements OfficeSuppliesService {

    @Autowired
    private OfficeSuppliesMapper officesuppliesmapper;

    @Autowired
    private OfficeSuppliesChangeRecordMapper recordMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return officesuppliesmapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insertSelective(OfficeSupplies record) {
        return officesuppliesmapper.insertSelective(record);
    }

    @Override
    public OfficeSupplies selectByPrimaryKey(Integer id) {
        return officesuppliesmapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OfficeSupplies record) {
        return officesuppliesmapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OfficeSupplies record) {
        return officesuppliesmapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OfficeSupplies> selectAllList() {
        return officesuppliesmapper.selectAllList();
    }

    @Override
    public List<OfficeSuppliesChangeRecord> selectPageRecordList(OfficeSuppliesChangeRecordPageParam param) {
        return recordMapper.selectPageRecordList(param);
    }

    @Override
    public int insertRecord(OfficeSuppliesChangeRecord recode) {
        return recordMapper.insertSelective(recode);
    }
}
