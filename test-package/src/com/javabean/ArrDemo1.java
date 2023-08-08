package com.javabean;
/*
* 设计一个方法遍历数组
* 【11,22】
* */
public class ArrDemo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        arrForEach(arr);
    }
    public static void arrForEach(int[] arr){
        System.out.print("[");
        for (int i = 0; i   <arr.length ; i++) {
            if(i== arr.length-1){
                System.out.print(arr[i]+"]");
            }else {
                System.out.print(arr[i]+",");
            }

        }

    }
}
