/*
 * 1423. Maximum Points You Can Obtain from Cards
Solved
Medium
Topics
Companies
Hint
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 */
/*
 * Approach
 * ✅ Hint:
Instead of directly thinking about taking k cards from the start or end, think of it as leaving a window of size (n - k) in the middle.

Calculate the sum of the entire array, then find the minimum sum of the (n - k) window.

The answer will be the total sum minus this minimum window sum.

Why?

If we maximize the sum of the cards taken, it’s equivalent to minimizing the sum of the remaining cards.

This sliding window approach gives O(n) time complexity, making it optimal.

How would you set up the initial window sum and slide it across the array? Want to give it a shot?
 */
public class maxSum {
    public int maxScore(int[] cardPoints, int k) {
        int allSum = 0;
        int n = cardPoints.length;
        int maxSum = 0;
        for(int i = 0;i<n;i++){
            allSum+=cardPoints[i];
        }
        if(n==k)return allSum;
        int valSum = 0;
        for(int i=0;i<n-k;i++){
            valSum+=cardPoints[i];
        }
        maxSum = Math.max(allSum-valSum,maxSum);
        int i =0;
        int j =n-k;
        while(j<n){
            //add the prefix val
            valSum+=cardPoints[j];
            //remove last val
            valSum -=cardPoints[i];
            maxSum = Math.max(allSum-valSum,maxSum);
            i++;
            j++;
        }

        return maxSum;

    }
    public static void main(String[] args) {
        int arr[] = {1,79,80,1,1,1,200,1};
        int k = 3;
        maxSum obj = new maxSum();
        System.out.println(obj.maxScore(arr, k));
        System.out.println("=====================");
    }
}
