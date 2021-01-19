package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDictDto;
import cn.net.yzl.ehr.pojo.DepartResumeDictListPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@FeignClient(value = "post",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
public interface DepartResumeDictService {


    public ComResponse<List<DepartResumeDictDto>> getDictList();

    public ComResponse<DepartResumeDictDto> getDictById(Integer id) ;

    ComResponse<List<DepartResumeDictDto>> selectListByName(String name) ;

     ComResponse<Integer> saveUpdate(DepartResumeDictListPo listPo,String staffNo);

}
