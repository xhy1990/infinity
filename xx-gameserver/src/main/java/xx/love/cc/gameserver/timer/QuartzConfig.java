package xx.love.cc.gameserver.timer;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xx.love.cc.gameserver.timer.job.TestJob;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/5
 */
@Configuration
public class QuartzConfig {

    /*** test */
    @Bean
    public JobDetail testJob() {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(TestJob.class)
                // 指定任务的名称
//                .withIdentity("TestJob")
                // 任务描述
//                .withDescription("哈哈哈")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger testTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(60)
                .repeatForever();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 0 * * ?");
        // 创建触发器
        return TriggerBuilder.newTrigger()
                // 绑定工作任务
                .forJob(testJob())
                .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(scheduleBuilder)
                .build();

    }






}
