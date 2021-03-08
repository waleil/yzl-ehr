package cn.net.yzl.ehr.dto.resume;

import cn.net.yzl.ehr.pojo.AreaPo;
import cn.net.yzl.staff.dto.resume.*;
import cn.net.yzl.staff.util.DateStaffUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Data
public class ResumeExportDto {
    private String name;
    private String sex;
    private String phone;
    private String email;


    private String degreeName;
    private String schoolName;
    private String startEndTime;
    private ResumeEduDto resumeEduDto;
    private String sourceName;
    private String intentionName;

    private String departName;
    private String postName;
    private String pDepartName;
    private ResumeDepartPostDto resumeDepartPostDto;


    private int entryTimes;
    @JsonFormat(pattern = "yyyy年HH月dd日")
    private Date createTime;
    private String creator;

    private String resumeDepartStaffDesc;

    private ResumeDepartStaffDto resumeDepartStaffDto;

    private ResumeInterviewTimeDto resumeInterviewTimeDto;

    private String resumeNodeName;
    private String resultCodeName;
    private String evaluate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date interviewTime;
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date entryTime;
    private Integer nature;
    private String natureStr;
    private String partnerCodeStr;
    private String workCodeStr;
    private String contractFile;
    private String backCard;
    private String article;
    private ResumeDbDto resumeDbDto;
    private String reasonCodeName;
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date rdCreateTime;

    @JsonFormat(
            pattern = "yyyy年MM月dd日"
    )
    protected Date followUpTime;
    protected String followUpStr;
    @ApiModelProperty(
            value = "跟进状态(1:正常,2:超时)",
            name = "followUpStatus"
    )
    protected Integer followUpStatus;

    private String followUpStatusStr;
    private String creatorName;
    public Integer getFollowUpStatus() {
        return followUpStatus;
    }

    public void setFollowUpStatus(Integer followUpStatus) {
        if(followUpStatus!=null){
            followUpStatusStr=followUpStatus==1?"正常":"超时";
        }
        this.followUpStatus = followUpStatus;
    }

    public void setResumeDbDto(ResumeDbDto resumeDbDto) {
        if (resumeDbDto!=null){
            reasonCodeName=resumeDbDto.getReasonCodeName();
            rdCreateTime=resumeDbDto.getCreateTime();
        }
        this.resumeDbDto = resumeDbDto;
    }

    public void setNature(Integer nature) {
        if(nature!=null){
            this.natureStr=nature==1?"正编":"外包";
        }
        this.nature = nature;
    }

    public void setResumeInterviewTimeDto(ResumeInterviewTimeDto resumeInterviewTimeDto) {
        if(resumeInterviewTimeDto!=null){
            this.resumeNodeName=resumeInterviewTimeDto.getResumeNodeName();
            this.resultCodeName=resumeInterviewTimeDto.getResultCodeName();
            this.evaluate=resumeInterviewTimeDto.getEvaluate();
            this.interviewTime=resumeInterviewTimeDto.getInterviewTime();
            this.resumeInterviewTimeDto = resumeInterviewTimeDto;
        }
    }

    public void setResumeDepartStaffDto(ResumeDepartStaffDto resumeDepartStaffDto) {
        if(resumeDepartStaffDto!=null){

            this.resumeDepartStaffDesc=resumeDepartStaffDto.getDesc();
            this.resumeDepartStaffDto = resumeDepartStaffDto;
        }
    }

    public void setSex(Byte sex) {
        this.sex=sex==0?"男":"女";
    }

    public ResumeEduDto getResumeEduDto() {
        return resumeEduDto;
    }
    public void setResumeEduDto(ResumeEduDto resumeEduDto) throws ParseException {
        if(resumeEduDto!=null){

            degreeName=resumeEduDto.getDegreeName();
            schoolName=resumeEduDto.getSchoolName();
            if(resumeEduDto.getStartData()!=null && resumeEduDto.getEndData()!=null){
                startEndTime= DateStaffUtils.dateToDateStr(resumeEduDto.getStartData(),"yyyy-MM-dd")+"--"+DateStaffUtils.dateToDateStr(resumeEduDto.getEndData(),"yyyy-MM-dd");

            }else if(resumeEduDto.getStartData()!=null){
                startEndTime= DateStaffUtils.dateToDateStr(resumeEduDto.getStartData(),"yyyy-MM-dd")+"--";
            }else if(resumeEduDto.getStartData()!=null){
                startEndTime="--"+ DateStaffUtils.dateToDateStr(resumeEduDto.getEndData(),"yyyy-MM-dd");
            }
            this.resumeEduDto = resumeEduDto;
        }
    }

    public ResumeDepartPostDto getResumeDepartPostDto() {
        return resumeDepartPostDto;
    }

    public void setResumeDepartPostDto(ResumeDepartPostDto resumeDepartPostDto) {
        if(resumeDepartPostDto!=null){
            departName=resumeDepartPostDto.getDepartName();
            postName=resumeDepartPostDto.getPostName();

            pDepartName=resumeDepartPostDto.getPDepartName();
            this.resumeDepartPostDto = resumeDepartPostDto;
        }
    }
}
