/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device.impl;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleContext;
import org.protozoo.device.AbstractDevice;
import org.protozoo.device.Pinger;
import static org.protozoo.system.core.type.Capability.OFF;
import static org.protozoo.system.core.type.Capability.ON;
import static org.protozoo.system.core.type.Capability.PING;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import org.quartz.CronTrigger;
import static org.quartz.DateBuilder.evenMinuteDate;
import org.quartz.Job;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author wolfgang
 */
public class PingerImpl extends AbstractDevice implements Pinger {

    private static final String CATEGORY = "pinger";
    private static final String PID = Pinger.class.getName();

    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched;

    public PingerImpl() {
        super(CATEGORY, PID);
        addCapability(ON, OFF, PING);
    }

    @Override
    public void register(BundleContext bc) {

        super.register(bc);
        
        try {
            sched = sf.getScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(PingerJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // compute a time that is on the next round minute
            Date runTime = evenMinuteDate(new Date());

            // Trigger the job to run on the next round minute
            CronTrigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(cronSchedule("0/20 * * * * ?"))
                    .build();

            // Tell quartz to schedule the job using our trigger
            sched.scheduleJob(job, trigger);

            sched.start();

        } catch (SchedulerException ex) {
            Logger.getLogger(PingerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unregister() {
        try {
            if (sched != null) {
                sched.shutdown();
            }
        } catch (SchedulerException ex) {
            Logger.getLogger(PingerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.unregister();
    }

    public static class PingerJob implements Job {

        public PingerJob() {
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("==> PING");
        }
    }
}
