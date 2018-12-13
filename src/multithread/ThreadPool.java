package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class BasicTack implements Runnable{
    int taskId;
    int loopNum;
    public BasicTack(int taskId,int loopNum){
        this.loopNum=loopNum;
        this.taskId=taskId;
    }
    public void run(){
        for(int i=0;i<loopNum;i++){
            System.out.println("Task: "+this.taskId+"   "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Task:   "+this.taskId);
                break;
            }
        }
    }
}
public class ThreadPool {

    public static void main(String[] args) {
         int number=3;
         final int loopnum=3;
         final int tasknum=5;   //任务数
        ExecutorService ex=Executors.newFixedThreadPool(number);
        for(int i=1;i<=tasknum;i++){
             BasicTack task=new BasicTack(i,loopnum);
             ex .submit(task);
        }
        ex.shutdownNow();
    }

}

