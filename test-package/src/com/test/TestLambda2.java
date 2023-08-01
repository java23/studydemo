package com.test;

public class TestLambda2 {
   static  String msg ="show1";
    public static void main(String[] args) {
//        useShowHandler(new ShowHandler() {
//            @Override
//            public int getNumber(int i) {
//                return i;
//            }
//        });
        useShowHandler(i->
              1
         );


//
    }

    static void useShowHandler(ShowHandler showHandler){
        int result =showHandler.getNumber(1);
        System.out.println(result);
     }
}
interface  ShowHandler{
   int getNumber(int j);
}
