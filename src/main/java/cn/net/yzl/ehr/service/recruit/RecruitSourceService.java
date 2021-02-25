package cn.net.yzl.ehr.service.recruit;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.staff.dto.recruit.RecruitOperatingRecordDto;
import cn.net.yzl.staff.dto.recruit.RecruitSourceDto;
import cn.net.yzl.staff.dto.recruit.RecruitSourceExpenseDto;
import cn.net.yzl.staff.pojo.recruit.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

public interface RecruitSourceService {

    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<List<RecruitSourceDto>> queryRecruit(RecruitSourceListPo recruitSourceListPo);

    ComResponse<List<RecruitSourceDto>> queryState();

    ComResponse<List<RecruitSourceDto>> queryAll();

    ComResponse<Integer> addRecruit(RecruitSourceInsertPo insertPo,String staffNo);

    ComResponse<Integer> modity(RecruitSourceUpdateListPo updateListPo,String staffNo);

    ComResponse<Integer> update(RecruitSourceUpdatePo updatePo,String staffNo);

    ComResponse<Integer> getRecruitInfo( RecruitSourceUpdatePo updatePo,String staffNo);

    ComResponse<Page<RecruitSourceDto>> queryPage(RecruitSourceListPo recruitSourceListPo);

    ComResponse<Integer> updateState(RecruitSourceUpdateStatePo updatePo, String staffNo);

    ComResponse <List<RecruitOperatingRecordDto>> selectByPrimaryKey( Integer resourceId,  String staffNo);
}
