package com.test;

public class TestNoNameInner {
    public static void main(String[] args) {
        new InnerNoName(){
            public  void show(){
                System.out.println("this is no name");
            }
        }.show();
        InnerImpl innerImpl = new InnerImpl();
        innerImpl.show();
    }
}
interface InnerNoName{
    public  abstract void show();
}
class  InnerImpl implements  InnerNoName{
    public void show(){
        System.out.println("this is inner ");
    }
}
