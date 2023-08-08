package com.javabean;

public class ArrDemo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,5,2};
        System.out.println(arrMax(arr));
    }
    public static int arrMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
