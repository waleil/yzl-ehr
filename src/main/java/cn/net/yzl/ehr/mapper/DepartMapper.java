package cn.net.yzl.ehr.mapper;

import cn.net.yzl.ehr.pojo.DepartPo;
import feign.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartMapper {
    int deleteByPrimaryKey(Integer id);

    int save(DepartPo record);

    DepartPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepartPo record);

    int updateByPrimaryKey(DepartPo record);

    DepartPo getByDingIdAndCropId(@Param("parentid") Long parentid, @Param("corpId") String corpId);
}