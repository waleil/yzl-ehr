package cn.net.yzl.ehr.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时的一个操作
 */
@Component
@EnableScheduling
@EnableAutoConfiguration
public class Task {



    private Logger logger = LoggerFactory.getLogger(Task.class);


    //每5秒执行一次
    //@Scheduled(cron ="0/59 * * * * ?")
    //每1小时50分执行一次
    //@Scheduled(cron ="0 0/50 0/1 * * ?")
    //每1小时分执行一次
//    @Scheduled(cron ="0 0 0/1 * * ?")

    /**
     * 每一小时50分执行一次  获取 钉钉accesstoken
     */
    @Scheduled(cron = "0 0/50 0/1 * * ?")
    public void reflushDingAccessToken() {
        logger.info("每一小时50分执行一次  获取 钉钉access_token");
//        try {
////            defaultDingtalkToken.renewal();
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 系统每天 0点执行一次  获取考勤打卡记录
     */
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void getAttendanceRecord() {
        logger.info("系统每天 0点执行一次  获取考勤打卡记录....");


    }


}
