package xx.love.cc.gameserver.timer.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/5
 */
public class TestJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("test==================");
    }
}
