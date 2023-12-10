/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.32%)
 * Likes:    9799
 * Dislikes: 0
 * Total Accepted:    2.6M
 * Total Submissions: 6.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 3.longest-substring-without-repeating-characters.java
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    // 一个动态的滑动窗口。
    // 需要返回最大的长度。
    // 使用Set来判断是否重复。
    // 终止条件，end =length
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            if (hashMap.containsKey(s.charAt(end))) {
                // 把重复字符的下一个字符作为start
                // 没有删除start前put的值，所以需要进行比较。
                start = Math.max(start, hashMap.get(s.charAt(end)) + 1);
            }
            max = Math.max(max, end - start + 1);
            hashMap.put(s.charAt(end), end);

        }
        return max;
    }
}
// @lc code=end
