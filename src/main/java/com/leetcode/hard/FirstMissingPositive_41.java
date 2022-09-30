package com.leetcode.hard;

public class FirstMissingPositive_41 {


    public static int firstMissingPositive(int[] arr) {
        int pointer = 0;
        while (pointer < arr.length) {
            int current = arr[pointer];
            if (current > 0 && current <= arr.length && current != arr[arr[pointer] -1] )
                swap(arr, pointer, arr[pointer] - 1);
            else
                pointer++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i+1 != arr[i])
                return i + 1;
        }
        return arr.length+1;
    }

    private static void swap(int[] arr, int pointer, int current) {
        int temp = arr[current];
        arr[current] = arr[pointer];
        arr[pointer] = temp;
    }


    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0})); //3
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1})); // 2
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12})); //1
    }

}