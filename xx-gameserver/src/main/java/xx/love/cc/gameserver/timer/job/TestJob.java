package xx.love.cc.gameserver.timer.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/5
 */
@Slf4j
public class TestJob extends QuartzJobBean {
    @Override
    protected void executeInternal(@NonNull JobExecutionContext context) throws JobExecutionException {
        log.info("test==================");
    }
}
