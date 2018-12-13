package multithread;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class  ScheduleTask implements  Runnable{
    private int taskId;
      @Override
    public void run() {
        LocalDateTime current=LocalDateTime.now();
        System.out.println(this.taskId+"  "+current);
    }
    public  ScheduleTask(int taskId){
        this.taskId=taskId;
    }
}
public class ScheduledThread {
    public static void main(String[] args) {
        int threadnum=3;
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(threadnum);
        ScheduleTask task1=new ScheduleTask(1);
        ScheduleTask task2=new ScheduleTask(2);
        scheduledExecutorService.schedule(task1,2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task2,0,10,TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
    }

}
