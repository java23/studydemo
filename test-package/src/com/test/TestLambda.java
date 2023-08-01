package com.test;

public class TestLambda {
    public static void main(String[] args) {
//        SwimmingImpl swimming = new SwimmingImpl();
//        goSwimming(swimming);

        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("swimming");
            }
        });
        goSwimming(()->{
            System.out.println("swimming");
        });

    }
    public static void goSwimming(Swimming swimming){
        swimming.swim();
    }
}
interface Swimming{
    void swim();
}
class SwimmingImpl implements Swimming{

    @Override
    public void swim() {
        System.out.println("swimming");
    }
}

