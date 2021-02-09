package cn.net.yzl.ehr.service.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceInsertPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceListPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceUpdateListPo;
import cn.net.yzl.staff.pojo.recruit.RecruitSourceUpdatePo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RecruitSourceService {

    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<List<RecruitSourceDto>> queryRecruit(RecruitSourceListPo recruitSourceListPo);

    ComResponse<List<RecruitSourceDto>> queryState();

    ComResponse<Integer> addRecruit(RecruitSourceInsertPo insertPo,String staffNo);

    ComResponse<Integer> modity(RecruitSourceUpdateListPo updateListPo);

    ComResponse<Integer> update(RecruitSourceUpdatePo updatePo,String staffNo);

    ComResponse<Integer> getRecruitInfo( RecruitSourceUpdatePo updatePo,String staffNo);

    ComResponse<Page<RecruitSourceDto>> queryPage(RecruitSourceListPo recruitSourceListPo);
}
