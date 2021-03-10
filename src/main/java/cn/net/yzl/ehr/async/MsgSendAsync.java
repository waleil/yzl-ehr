package cn.net.yzl.ehr.async;


import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.SysDictDataDto;
import cn.net.yzl.ehr.fegin.common.SysDictDataFeginService;
import cn.net.yzl.ehr.fegin.resume.ResumeFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.resume.ResumeDetailDto;
import cn.net.yzl.staff.util.DateStaffUtils;
import cn.net.yzl.staff.vo.resume.ResumeInterviewInsertVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 *  消息发送
 *
 */
@Component
public class MsgSendAsync {
    @Autowired
    private StaffFeginService staffFeginService;
    @Autowired
    private ResumeFeginService resumeFeginService;
    @Autowired
    private SysDictDataFeginService  sysDictDataFeginService;

    @Autowired
    private YMsgInfoService ymsgInfoService;

    private String dateFormatStr="yyyy年MM月dd日 HH时mm分ss秒"; // 时间格式化

    /**
     *  消息发送  发送安排面试的消息
     *
     * @param resumeInterviewInsertVO
     * @param staffNo
     */
//    @Async
    public void  sendArrangeinfo(ResumeInterviewInsertVO resumeInterviewInsertVO,String staffNo)  {

        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0004");
        templateVo.setCreator(staffNo);
        templateVo.setUserCode(resumeInterviewInsertVO.getInterviewStaffNo());
        templateVo.setSystemCode(2);
        templateVo.setTitle("安排面试");
        // {0}你好，将于{1}，进行对“{2}”“{3}”的“{4}”，请须知。
        String staffName=""; //面试官姓名

        String interviewStaffNo = resumeInterviewInsertVO.getInterviewStaffNo();
        // 获取用户信息
        ComResponse<StaffDetailsDto> detailsByNo = staffFeginService.getDetailsByNo(interviewStaffNo);
        if(detailsByNo!=null && detailsByNo.getData()!=null){
            staffName = detailsByNo.getData().getName();
        }

        String interviewTimeStr="";// 面试时间
        Date interviewTime = resumeInterviewInsertVO.getInterviewTime();  // 面试时间
        if(interviewTime!=null){
            try {
                interviewTimeStr= DateStaffUtils.dateToDateStr(interviewTime, dateFormatStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // 获取简历信息
        String postName="";// 应聘的岗位名称
        String jobStaffName="";// 求职者名称
        Integer resumeId = resumeInterviewInsertVO.getResumeId();
        ComResponse<ResumeDetailDto> resumeDetail = resumeFeginService.getResumeDetail(resumeId);
        if(resumeDetail.getData()!=null){
            ResumeDetailDto data = resumeDetail.getData();
            postName = data.getResumeDepartPostDto().getPostName();
            jobStaffName=data.getName();
        }

        // 获取面试类型
        Integer typeCode = resumeInterviewInsertVO.getTypeCode();
        AtomicReference<String> typeCodeName= new AtomicReference<>("");
        ComResponse<List<SysDictDataDto>> interview_type =
                sysDictDataFeginService.getByType("interview_type");
        if(interview_type.getData()!=null){
            interview_type.getData().stream().forEach(sysDictDataDto -> {
                if(sysDictDataDto.getDictCode().equals(typeCode)){
                    typeCodeName.set(sysDictDataDto.getDictValue());
                }

            });
        }

        String[] str = {staffName,interviewTimeStr,postName,jobStaffName,typeCodeName.get()};
        templateVo.setParams(str);
        ymsgInfoService.sendSysMsgInfo(templateVo);

    }




    /**
     *  消息发送  发送（推送）给部门
     *
     * @param staffNo  收消息 用户编号
     *        creator  发消息 用户编号
     * @param staffNo
     */
    @Async
    public void  sendToDepart(String creator ,String staffNoAndName) {
        if(StrUtil.isBlank(staffNoAndName)){
            return;
        }
        String[] split = staffNoAndName.split(",");
        if(split.length!=2){
            return;
        }

        // 获取简历详情
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0005");
        templateVo.setCreator(creator);
        templateVo.setUserCode(split[0]);
        templateVo.setSystemCode(2);
        templateVo.setTitle("待筛选");
        // {0}你好，于{1}，收到待筛选简历，请前往筛选。


        String timeStr="";// 时间

            try {
                timeStr= DateStaffUtils.dateToDateStr(new Date(), dateFormatStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        String[] str = {split[1],timeStr};
        templateVo.setParams(str);
        ymsgInfoService.sendSysMsgInfo(templateVo);

    }



    /**
     *  消息发送 待选简历 更新
     *
     * @param staffNo  收消息 用户编号
     *        creator  发消息 用户编号
     * @param staffNo
     */
//    @Async
    public void  resumeUpdateInfo(String send ,String to) {


        // 获取简历详情
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0020");
        templateVo.setCreator(send);
        templateVo.setUserCode(to);
        templateVo.setSystemCode(2);
        templateVo.setTitle("待选简历-结果");
        // {0}你好，于{1}，收到待筛选简历，请前往筛选。
        ymsgInfoService.sendSysMsgInfo(templateVo);

    }

    /**
     *  消息发送 待选简历 更新
     *
     * @param staffNo  收消息 用户编号
     *        creator  发消息 用户编号
     * @param staffNo
     */
//    @Async
    public void  resumeInterviewUpdateInfo(String send ,String to) {


        // 获取简历详情
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0021");
        templateVo.setCreator(send);
        templateVo.setUserCode(to);
        templateVo.setSystemCode(2);
        templateVo.setTitle("面试结果-通知");
        // {0}你好，于{1}，收到待筛选简历，请前往筛选。
        ymsgInfoService.sendSysMsgInfo(templateVo);

    }
}