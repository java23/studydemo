package com.test;

import jdk.swing.interop.SwingInterOpUtils;

public class TestQuestion1 {
    public static void main(String[] args) {
        double i = 0.1;
        int count_number = 0;
        while (i<8844430){
            i = i*2;
            count_number++;
        }
        System.out.println(count_number);
    }
}
