package com.example.demo;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int i){
        if (i==arr.length)
            return 0;
        return arr[i]+sum(arr,i+1);
    }

    public static  void main(String[] args){
        int[] nums={1,2,3,4,5};
        System.out.println(sum(nums));
    }
}
