package com.test;

public class TestNumber2 {
    public static void main(String[] args) {
          int a = 100;
          int b = 20;
          int c = 0;
          while (a>=b){
              a = a-b;
              c++;
          }
        System.out.println("商是"+c+"余数是"+a);
    }
}
