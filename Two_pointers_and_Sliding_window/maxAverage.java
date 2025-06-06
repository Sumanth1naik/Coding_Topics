/*
 * 643. Maximum Average Subarray I
Easy
Topics
Companies
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 */

 class maxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double average = 0;
        for(int i = 0;i < k ; i++){
            sum+=nums[i];
        }
        average = (double) sum/k;
        int i = 0;
        int j = k;
        while(j<nums.length){
            //add the prefix value;
            sum+=nums[j];
            //substract the leaving value
            sum-=nums[i];
            double val = (double) sum/k;
            average = Math.max(average,val);
            i++;
            j++;
        }
        return average;

    }

    public static void main(String[] args) {
        maxAverage obj  = new maxAverage();
        int []arr = {1,12,-5,-6,50,3};
        int k  = 4;
        System.out.println(obj.findMaxAverage(arr, k));
        System.out.println("==========================");
    }
}