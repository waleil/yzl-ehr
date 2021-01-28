package cn.net.yzl.ehr.service.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceInsertPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceUpdateListPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceUpdatePo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RecruitSourceService {

    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<RecruitSourceDto> queryRecruit(Integer id);

    ComResponse<Integer> addRecruit(RecruitSourceInsertPo insertPo);

    ComResponse<Integer> modity(@RequestBody RecruitSourceUpdateListPo updateListPo);

    ComResponse<Integer> update(RecruitSourceUpdatePo updatePo);

    ComResponse<Integer> getRecruitInfo(@RequestBody RecruitSourceUpdatePo updatePo);

    ComResponse<Page<RecruitSourceDto>> queryPage(Integer pageSize, Integer pageNum);
}
