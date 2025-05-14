/*
 * 1456. Maximum Number of Vowels in a Substring of Given Length
Medium
Topics
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
 */

 import java.util.*;
 public class maxVowels {
 
    public int maxVowel(String s, int k) {
        int maxAns = 0;
        for(int i =0;i<k;i++){
            char val = s.charAt(i);
            if(val == 'a'|| val == 'e' || val == 'i' || val == 'o' || val == 'u'){
                maxAns++;
            }
        }
        int i = 0;
        int j = k;
        int ans = maxAns;
        while(j<s.length()){
            char strt = s.charAt(i);
            char end = s.charAt(j);
            if(end == 'a'|| end == 'e' || end == 'i' || end == 'o' || end == 'u'){
                ans++;
            }
            if(strt == 'a'|| strt == 'e' || strt == 'i' || strt == 'o' || strt == 'u'){
                ans--;
            }
            
            maxAns = Math.max(ans, maxAns);
           i++;
           j++;


        }
        return maxAns;
    }
    public static void main(String[] args) {
        maxVowels obj = new maxVowels();
        String s = "leetcode";
        int k = 3;
        System.err.println(obj.maxVowel(s, k));
        System.err.println("------------------------");
    }
    
 }