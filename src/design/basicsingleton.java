package design;


class EagerSingleton{
    private static final EagerSingleton instance=new EagerSingleton();

    private String pow= "I yao eat ren";


    private  EagerSingleton(){
        //构造方法为私有，不存在构造函数
    }
    public String getPow() {
        return pow;
    }
   public static EagerSingleton getInstance(){
        return  instance;
   }
}
public class basicsingleton {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton=EagerSingleton.getInstance();
        System.out.println(eagerSingleton.getPow());
    }
}
