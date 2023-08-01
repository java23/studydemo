package com.test;

import java.util.Scanner;

public class TestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要判断的整数: ");
        int number = scanner.nextInt();
       /* String str = String.valueOf(number);
        byte[] numbers= str.getBytes();
        byte[] new_numbers = new byte[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
              new_numbers[i] = numbers[numbers.length-i-1];

        }
        boolean flag = true;
        for (int i = 0; i < new_numbers.length; i++) {
             if(new_numbers[i]!=numbers[i]){
                 flag= false;
                 break;
             }
        }*/
        int tmp = number;
        int new_number = 0;
        while (tmp!=0){
            int ge =   tmp%10;
            tmp = tmp/10;
            new_number = new_number*10+ge;
        }
        System.out.println(new_number);
        System.out.println(number);
        System.out.println(number==new_number);
    }
}
