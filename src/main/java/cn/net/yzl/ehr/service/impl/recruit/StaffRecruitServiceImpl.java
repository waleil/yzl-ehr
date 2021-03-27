package cn.net.yzl.ehr.service.impl.recruit;

import cn.hutool.core.date.DateUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.async.MsgSendAsync;
import cn.net.yzl.ehr.fegin.recruit.StaffRecruitFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.service.StaffRecruitService;
import cn.net.yzl.pm.model.dto.MenuDTO;
import cn.net.yzl.pm.service.RoleMenuService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.recruit.StaffRecruitDto;
import cn.net.yzl.staff.pojo.recruit.RecruitedTaskPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitSelectPo;
import cn.net.yzl.staff.pojo.recruit.StaffRecruitUpdatePo;
import cn.net.yzl.staff.util.DateStaffUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class StaffRecruitServiceImpl implements StaffRecruitService {
    @Autowired
    private MsgSendAsync msgSendAsync;
    @Autowired
    private StaffFeginService staffFeginService;
    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private StaffRecruitFeginService staffRecruitFeginService;

    @Override
    public ComResponse<Integer> addStaffRecruitApply(StaffRecruitPo staffRecruitPo) {
        return staffRecruitFeginService.addStaffRecruitApply(staffRecruitPo);
    }

    @Override
    public ComResponse<Integer> updateStaffRecruitApply(StaffRecruitUpdatePo staffRecruitPo) {
        return staffRecruitFeginService.updateStaffRecruitApply(staffRecruitPo);
    }

    @Override
    public ComResponse<Page<StaffRecruitDto>> getWithTaskByPo(StaffRecruitSelectPo staffRecruitSelectPo, HttpServletRequest request) {

        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        log.info(JsonUtil.toJsonStr(menuDTO));
        menuDTO.getMenuName();//获取菜单名称
        menuDTO.getIsAdmin();//获取最高权限标识
        //最高权限标识
        if(menuDTO!=null && menuDTO.getIsAdmin()!=null && menuDTO.getIsAdmin()==1 ){
            //全量，只根据departId查询
            staffRecruitSelectPo.setCurrentStaffNo(null);
        }else{
            //会增加部门负责人限制
            staffRecruitSelectPo.setCurrentStaffNo(userNo);
        }
        return staffRecruitFeginService.getWithTaskByPo(staffRecruitSelectPo);
    }

    @Override
    public ComResponse<StaffRecruitDto> getById(Integer id) {
        return staffRecruitFeginService.getById(id);
    }

    @Override
    public ComResponse<Integer> updateResumeFollowTime(Integer num, String staffNo) {
        return staffRecruitFeginService.updateResumeFollowTime(num,staffNo);
    }

    @Override
    public ComResponse<Integer> batchDistributeTask(List<RecruitedTaskPo> recruitedTaskPos) {

        if(recruitedTaskPos!=null && !recruitedTaskPos.isEmpty()){
            String receiver = recruitedTaskPos.get(0).getReceiver();
            String creator = recruitedTaskPos.get(0).getCreator();
            ComResponse<StaffDetailsDto> detailsByNo = staffFeginService.getDetailsByNo(receiver);
            if(detailsByNo==null){
              return ComResponse.fail(ResponseCodeEnums.STAFF_NOT_EXIT_CODE.getCode(),ResponseCodeEnums.STAFF_NOT_EXIT_CODE.getMessage());
            }
            try{
            msgSendAsync.distributeStaffRecruitNotice(creator==null?"任务分配":creator,receiver,detailsByNo.getData().getName(),DateUtil.now());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return staffRecruitFeginService.batchDistributeTask(recruitedTaskPos);
    }
}
