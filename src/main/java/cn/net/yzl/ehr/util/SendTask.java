package cn.net.yzl.ehr.util;

import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.order.model.vo.MailVo;
import cn.net.yzl.order.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 邮件任务发送
 *
 * @author biebaojie
 */
@Component
public class SendTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendTask.class);

    public synchronized void runTask(List<MailVo> mailVoList) {
        int size = mailVoList.size();
        int unitNum = 500;
        int startIndex = 0;

        while (size > 0) {
            int endIndex;
            if (size > unitNum) {
                endIndex = startIndex + unitNum;
            } else {
                endIndex = startIndex + size;
            }

            List<MailVo> insertData = mailVoList.subList(startIndex, endIndex);
            CountDownLatch latch = new CountDownLatch(insertData.size());
            long start = System.currentTimeMillis();

            for (int i = 0; i < insertData.size(); ++i) {
                sendMail(insertData, i, latch);
            }

            try {
                latch.await();
                size -= unitNum;
                startIndex = endIndex;
                long end = System.currentTimeMillis();
                if (endIndex - endIndex >= 500) {
                    while (60000L - (end - start) >= 0L) {
                        Thread.sleep(60000L - (end - start));
                    }
                }
            } catch (InterruptedException var11) {
                var11.printStackTrace();
            }
        }

    }

    @Async("performanceServiceExecutor")
    public void sendMail(List<MailVo> insertData, int i, CountDownLatch latch) {
        MailVo mailVo = insertData.get(i);
        try {
            MailUtil.sendMail(mailVo);
            latch.countDown();
            TimeUnit.MICROSECONDS.sleep(10L);
        } catch (Exception e) {
            LOGGER.error("发送邮件失败. message={}", JsonUtil.toJsonStr(mailVo), e);
        }
    }
}
