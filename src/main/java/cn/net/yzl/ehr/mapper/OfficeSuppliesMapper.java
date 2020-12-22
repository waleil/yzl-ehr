package cn.net.yzl.ehr.mapper;


import cn.net.yzl.ehr.pojo.OfficeSupplies;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OfficeSuppliesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OfficeSupplies record);

    int insertSelective(OfficeSupplies record);

    OfficeSupplies selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OfficeSupplies record);

    int updateByPrimaryKey(OfficeSupplies record);

    List<OfficeSupplies> selectAllList();
}