package cn.net.yzl.ehr.util;

import cn.net.yzl.ehr.dto.StaffAbnorRecordDto;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.staff.pojo.RunAbnorRecordPo;

import java.text.DecimalFormat;
import java.util.List;

public class TransformMinuteUtil {

    public static RunAbnorRecordPo getTransformMinuteRunAbnorRecordPo(RunAbnorRecordPo runAbnorRecordPo){
        if(runAbnorRecordPo==null){
            return null;
        }
        if(runAbnorRecordPo.getAdjustFullAttendanceSalaryLater()!=null){
            runAbnorRecordPo.setAdjustFullAttendanceSalaryLater(runAbnorRecordPo.getAdjustFullAttendanceSalaryLater()*100);
        }
        if(runAbnorRecordPo.getAdjustPerformanceSalaryLater()!=null){
            runAbnorRecordPo.setAdjustPerformanceSalaryLater(runAbnorRecordPo.getAdjustPerformanceSalaryLater()*100);
        }
        if(runAbnorRecordPo.getAdjustWageSalaryLater()!=null){
            runAbnorRecordPo.setAdjustWageSalaryLater(runAbnorRecordPo.getAdjustWageSalaryLater()*100);
        }
        if(runAbnorRecordPo.getAdjustBasicSalaryLater()!=null){
            runAbnorRecordPo.setAdjustBasicSalaryLater(runAbnorRecordPo.getAdjustBasicSalaryLater()*100);
        }
        if(runAbnorRecordPo.getAdjustBasicSalaryTypeLater()!=null){
            runAbnorRecordPo.setAdjustBasicSalaryTypeLater(runAbnorRecordPo.getAdjustBasicSalaryTypeLater()*100);
        }
        return runAbnorRecordPo;
    }






    public void txfloat() {
        // TODO 自动生成的方法存根
        int a=9;
        int b=7;
        DecimalFormat df=new DecimalFormat("0.00");

        System.out.println(df.format((float)a/b));
        System.out.println(df.format(a/(float)b));
        System.out.println(df.format((float)a/(float)b));
        System.out.println(df.format((float)(a/b)));
    }

}

