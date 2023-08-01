package com.test;

import java.util.concurrent.PriorityBlockingQueue;

public class TestInter {
    static int i = 1;
    static int j = 2;

    private String string = "这是TestInter成员变量";

    public static void test(InterfaceTest interfaceTest) {

        System.out.println(interfaceTest.show(i, j));
    }

    public static void main(String[] args) {

        test(new InterfaceTest() {
            @Override
            public int show(int i, int j) {
                return i + j;
            }
        });

        //test((i, j) ->i + j);
       // test((i, j)-> {return  i + j ;});
        test((int a, int b)-> {return  a + b ;});

    }


}

interface InterfaceTest {
    int show(int i, int j);

}



