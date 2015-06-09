package com.building.web;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.building.commons.base.BaseAction;
import com.building.service.ifc.ScheduleServiceIFC;
import com.building.service.impl.ScheduleServiceImpl;

public class TimerScheduleAction extends BaseAction{
    
    static Timer timer;
    private ScheduleServiceIFC scheduleServiceProxy;
    
    public String timer() {
        timer = new Timer();
        // 定时器20s执行一次
        timer.schedule(new RemindTask(),0 ,20 * 1000);
        return SUCCESS;
    }

    class RemindTask extends TimerTask implements Runnable{
        public void run() {
            System.out.println("任务开始执行..");
            Date date = new Date();
            scheduleServiceProxy.getScheduleTask(date);
        }
    }
    public void cancel(){
//      in cancle()
        timer.cancel();
        System.out.println("任务结束..");
    }
    
    public ScheduleServiceIFC getScheduleServiceProxy() {
        return scheduleServiceProxy;
    }
    
    public void setScheduleServiceProxy( ScheduleServiceIFC scheduleServiceProxy ) {
        this.scheduleServiceProxy = scheduleServiceProxy;
    }
    
}
