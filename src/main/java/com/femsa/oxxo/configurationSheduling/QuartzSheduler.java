package com.femsa.oxxo.configurationSheduling;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.femsa.oxxo.jobExecute.JobExecute;

@Configuration
public class QuartzSheduler {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(JobExecute.class)
                .withIdentity("miJob", "grupo1")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("miTrigger", "grupo1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")) // Ejecuta cada 2 minutos
                .build();
    }

    @Bean
    public Scheduler scheduler(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        Scheduler scheduler = org.quartz.impl.StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger); // Registra el JobDetail y Trigger
        scheduler.start(); // Inicia el scheduler
        return scheduler; // Retorna el scheduler ya configurado
    }
}
