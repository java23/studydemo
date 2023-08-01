package com.test;

public class TestAPI {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[8];
        System.arraycopy(a,a.length-2,b,b.length-2,2);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
