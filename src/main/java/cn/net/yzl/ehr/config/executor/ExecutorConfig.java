package cn.net.yzl.ehr.config.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author biebaojie
 */
@Configuration
@EnableAsync
public class ExecutorConfig {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    /**
     * 绩效服务线程池
     */
    @Bean("performanceServiceExecutor")
    public Executor performanceServiceExecutor() {
        logger.info("start performanceServiceExecutor");

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程核心数目
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        //最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(10);
        //配置队列大小
        threadPoolTaskExecutor.setQueueCapacity(500);
        //配置线程池前缀
        threadPoolTaskExecutor.setThreadNamePrefix("performance-service-");
        //配置拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //数据初始化
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
