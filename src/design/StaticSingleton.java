package design;

import sun.rmi.rmic.iiop.StaticStringsHash;

public class StaticSingleton {


        private  static StaticSingleton  instance;

        public static  StaticSingleton getInstance(){
            return instance;
        }

        private StaticSingleton(){}
        static{
            instance =new StaticSingleton();
        }
        @Override
        public String toString(){
            return "i am";
        }

        public static void main(String[] args) {
            StaticSingleton singleton=StaticSingleton.getInstance();
            System.out.println(singleton.toString());
        }
    }

