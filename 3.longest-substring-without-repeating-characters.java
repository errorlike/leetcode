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

import java.util.HashSet;

class Solution {
    // 一个动态的滑动窗口。
    // 需要返回最大的长度。
    // 使用Set来判断是否重复。
    // 终止条件，end =length
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        var set = new HashSet<Character>();
        for (int end = 0; end < s.length(); end++) {
            var charactar = s.charAt(end);
            if (set.add(charactar)) {
                maxLength = Math.max(maxLength, end - start + 1);
            } else {
                // 减小窗口到窗口内没有重复项
                while(!set.add(charactar)){
                    set.remove(s.charAt(start));
                    start ++;
                }
                set.add(charactar);
            }
        }

        return maxLength;
    }
}
// @lc code=end
