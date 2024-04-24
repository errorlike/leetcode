/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (54.93%)
 * Likes:    855
 * Dislikes: 0
 * Total Accepted:    97.8K
 * Total Submissions: 178K
 * Testcase Example:  '"ABAB"\n2'
 *
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you
 * can get after performing the above operations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * 
 * 
 */

// @lc code=start
class Solution {

    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] map = new int[26];
        for (int end = 0; end < s.length(); end++) {
            map[s.charAt(end) - 'A']++;
            // 窗口内字符数-maxCount > k
            maxCount = Math.max(maxCount, map[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                map[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;

    }
}
// @lc code=end
