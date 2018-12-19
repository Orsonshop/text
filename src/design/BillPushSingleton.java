package design;

//最省内存

public class BillPushSingleton {

    private  BillPushSingleton(){

    }
  private  static class  SingletonHelper{
        private  static final  BillPushSingleton instance=new BillPushSingleton();

  }

  public static BillPushSingleton getInstance(){
        return SingletonHelper.instance;
  }

  public static void main(String[] args) {
        BillPushSingleton singleton=BillPushSingleton.getInstance();
        System.out.println(singleton);
        BillPushSingleton singleton1=BillPushSingleton.getInstance();
        System.out.println(singleton1);
        BillPushSingleton singleton2=BillPushSingleton.getInstance();
        System.out.println(singleton2);
    }
}
