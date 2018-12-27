package design;



import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

interface IPublisher{
    void register(iSubscriber subscriber);

    void unregister(iSubscriber subscriber);

    void notifySubscibers();

    Object getUpdate(iSubscriber subscriber);
}
interface iSubscriber {
    void update();

    void setPublisher(MyPublisher publisher);
}
class  MyPublisher implements IPublisher{
    private List<iSubscriber> subscribers;
    private String message;
    private boolean changed;
    private final Object MUTEX=new Object();

    public MyPublisher(){
        this.subscribers=new ArrayList <>();
    }

    @Override
    public void register(iSubscriber subscriber) {
        if (subscribers==null){
            throw  new NullPointerException("invalid subscriber");
        }
        synchronized (MUTEX){
            if (!subscribers.contains(subscriber)){
                subscribers.add(subscriber);
                subscriber.setPublisher(this);
            }
        }

    }


    @Override
    public void unregister(iSubscriber subscriber) {
        synchronized (MUTEX){
            subscribers.remove(subscribers);
        }

    }

    @Override
    public void notifySubscibers() {
        List <iSubscriber> subscriberLocal;
        synchronized (MUTEX) {
            if (!changed)
                return;
            subscriberLocal = new ArrayList <>(this.subscribers);
            this.changed = false;

        }
        for (iSubscriber sub:subscribers){
            sub.update();
        }
    }

    @Override
    public Object getUpdate(iSubscriber subscriber) {
        System.out.println(subscriber.toString()+"receiving");
        return this.message;
    }
    public void publish(String msg){
        System.out.println("message::"+msg+"published");
        this.message=msg;
        this.changed=true;
        notifySubscibers();
    }
}
class MyTOpicSubscriber implements iSubscriber{
    private String name;
    private IPublisher topic;

    public MyTOpicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg=(String)topic.getUpdate(this);
        if (msg==null){
            System.out.println(name+"::ni new message");
        }else {
            System.out.println(name+"::consuming message::"+msg);
        }
    }

    @Override
    public void setPublisher(MyPublisher publisher) {
        this.topic=publisher;
    }
}
public class Observer {
    public static void main(String[] args) throws InterruptedException {
        MyPublisher publisher=new MyPublisher();
        iSubscriber tom=new MyTOpicSubscriber("tom");
        iSubscriber jerry=new MyTOpicSubscriber("jerry");
        iSubscriber leng=new MyTOpicSubscriber("leng");
        publisher.register(tom);
        publisher.register(jerry);
        publisher.register(leng);
        publisher.publish("welcom ro dharma world");
        sleep(3000);
        publisher.publish("dharm java design-pattern started");


    }

}