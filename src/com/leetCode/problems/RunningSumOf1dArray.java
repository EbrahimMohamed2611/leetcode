package com.leetCode.problems;

public class RunningSumOf1dArray {
	
	
	public int[] runningSum(int[] nums) {
        
		int[] arr2 = new int[nums.length];
		int sum = 0;
		for (int i = 0;  i< nums.length; i++) {
			sum =0;
			for (int j = 0; j <= i; j++) {
				
				sum = sum + nums[j];
				
			}
			arr2[i] = sum;
			//sum = 0;
		}
//		for (int i = 0; i < arr2.length; i++) {
//		System.out.println(arr2[i]);
//		}
		return arr2;
    }

	public static void main(String[] args) {
		int[] arr1= {1,1,1,1,1};
		RunningSumOf1dArray runningSumOf1dArray = new RunningSumOf1dArray();
		int[] summation  = runningSumOf1dArray.runningSum(arr1);
		for (int i = 0; i < summation.length; i++) {
			System.out.println(summation[i]);
		}
		

	}

}
