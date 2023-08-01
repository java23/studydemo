package com.test;

public class TestInterface1 {
    public static void main(String[] args) {
       InterImpl interImpl = new InterImpl();
       interImpl.show();
       interImpl.show2();
       Inter.show4();


    }
}
interface Inter{
     public static  final    int NUM = 10;
     public abstract  void show();
     public default void show2(){
         System.out.println(NUM);
     }
     public static void show4(){
         System.out.println("this is static  void ");
     }
     private void show5(){
         System.out.println();
     }
    private static void show6(){

    }
    public static  void show7(){
         show6();
    }
    public default void show3(){
         show5();
         show2();
    }
}
interface Inter2{
    public default  void show2(){
        System.out.println("this is inter2");


    }

    public  void show();
}
class  InterImpl implements Inter,Inter2{
    public void show(){
        System.out.println(NUM);

    }

    @Override
    public void show2() {

    }

}
