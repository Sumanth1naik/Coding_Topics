/*
 * 1297. Maximum Number of Occurrences of a Substring
Medium
Topics
Companies
Hint
Given a string s, return the maximum number of occurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
 

Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 occurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
Example 2:

Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
Output: 2
Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 

Constraints:

1 <= s.length <= 105
1 <= maxLetters <= 26
1 <= minSize <= maxSize <= min(26, s.length)
s consists of only lowercase English letters.
 */
import java.util.*;
class Solution {
    public int maxFrequence(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> subMap = new HashMap<>();
        int i =0;
        int j = minSize;
        int maxAns = 0;
        while(j<=s.length()){
            String subString   = s.substring(i,j);
            int count = maxLetters;
            HashSet<Character> wordSet = new HashSet<>();
            for(int l = 0;l<subString.length();l++){
                char val = subString.charAt(l);
                if(!wordSet.contains(val)){
                    wordSet.add(val);
                    count--;
                }
                if(count<0){
                    break;
                }
            }
            if(count >= 0){
                if(subMap.containsKey(subString)){
                    int val = subMap.get(subString);
                    val++;
                    subMap.put(subString,val);
                    maxAns = Math.max(maxAns,val);
                }
                else{
                    subMap.put(subString,1);
                    maxAns = Math.max(maxAns,1);
                }
            }
            i++;
            j++;
        }
        return maxAns;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "aaaaacbc";
        int maxLetters = 2;
        int  minSize = 4;
        int  maxSize = 6;
        System.err.println(obj.maxFrequence(s, maxLetters, minSize, maxSize));
        System.err.println("---------------------------");
    }
}

/*
 * Approach 2 and effiecient
 *  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    HashMap<String, Integer> subMap = new HashMap<>();
    HashMap<Character, Integer> freqMap = new HashMap<>();
    int maxAns = 0;
    int uniqueCount = 0;

    // Initial window setup
    for (int i = 0; i < minSize; i++) {
        char ch = s.charAt(i);
        freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        if (freqMap.get(ch) == 1) uniqueCount++;
    }

    // Check first window
    if (uniqueCount <= maxLetters) {
        String firstSubstring = s.substring(0, minSize);
        subMap.put(firstSubstring, subMap.getOrDefault(firstSubstring, 0) + 1);
        maxAns = subMap.get(firstSubstring);
    }

    // Sliding the window
    for (int i = minSize; i < s.length(); i++) {
        char newChar = s.charAt(i);
        char outgoingChar = s.charAt(i - minSize);

        // Add new character
        freqMap.put(newChar, freqMap.getOrDefault(newChar, 0) + 1);
        if (freqMap.get(newChar) == 1) uniqueCount++;

        // Remove outgoing character
        freqMap.put(outgoingChar, freqMap.get(outgoingChar) - 1);
        if (freqMap.get(outgoingChar) == 0) uniqueCount--;

        // Check the current window
        if (uniqueCount <= maxLetters) {
            String currentSubstring = s.substring(i - minSize + 1, i + 1);
            subMap.put(currentSubstring, subMap.getOrDefault(currentSubstring, 0) + 1);
            maxAns = Math.max(maxAns, subMap.get(currentSubstring));
        }
    }

    return maxAns;
}
 */
