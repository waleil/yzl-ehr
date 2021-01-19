//package cn.net.yzl.ehr.service.impl;
//
//import cn.net.yzl.common.entity.ComResponse;
//import cn.net.yzl.common.enums.ResponseCodeEnums;
//import cn.net.yzl.ehr.dto.StaffWorkListDto;
//import cn.net.yzl.ehr.fegin.staff.StaffEntryPostFeginService;
//import cn.net.yzl.ehr.fegin.staff.StaffWorkFeginService;
//import cn.net.yzl.ehr.pojo.StaffWorkInsertListPo;
//import cn.net.yzl.ehr.pojo.StaffWorkItemPo;
//import cn.net.yzl.ehr.pojo.StaffWorkUpdateListPo;
//import cn.net.yzl.ehr.pojo.StaffWorkUpdatePo;
//import cn.net.yzl.ehr.service.StaffEntryPostService;
//import cn.net.yzl.ehr.service.StaffWorkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StaffEntryPostServiceImpl implements StaffEntryPostService{
//
//
//    @Autowired
//    private StaffEntryPostFeginService staffEntryPostFeginService;
//
//
//    @Override
//    public ComResponse<Integer> insert(String staffNo) {
//        return staffEntryPostFeginService.insert(staffNo);
//    }
//}
