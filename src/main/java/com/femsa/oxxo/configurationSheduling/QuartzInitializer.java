package com.femsa.oxxo.configurationSheduling;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzInitializer {
	
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private JobDetail cronJobDetail;

    @Autowired
    private Trigger cronJobTrigger;

    public void initialize() {
        try {
            if (!scheduler.checkExists(cronJobDetail.getKey())) {
                scheduler.scheduleJob(cronJobDetail, cronJobTrigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
	
}
