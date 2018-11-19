package com.dixn.dxboot.scheduling;

import com.dixn.dxboot.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version v1.0
 * @Description：Send alarm info to tcdp
 * @projectName：FCS
 * @packageName： com.dixn.alarm
 * @ClassName：zhaoxu
 * @author：zhaoxu
 * @createTime：2018/8/31 16:12
 * @upate：zhaoxu
 * @updateDate：2018/8/31 16:12
 * @remark：
 */
@Configuration
@Slf4j
public class Scheduling implements SchedulingConfigurer {

	@Autowired
    RedisUtil redisUtil;

	@Value("${alarm_queue_cron}")
	private String cron;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(taskExecutor());
		taskRegistrar.getScheduler().schedule(() -> {
            System.out.println("11111111111111");
        }, new CronTrigger(cron));
	}

	@Bean("taskExecutor")
	public TaskScheduler taskExecutor() {
		ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
		executor.setPoolSize(20);
		executor.setThreadNamePrefix("alarm-Executor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		// wait times
		executor.setAwaitTerminationSeconds(60);
		return executor;
	}

}
