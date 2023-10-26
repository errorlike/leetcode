/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.cn/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (55.71%)
 * Likes:    563
 * Dislikes: 0
 * Total Accepted:    184.3K
 * Total Submissions: 330.8K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string s which consists of lowercase or uppercase letters, return
 * the length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length
 * is 1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * 
 * 
 */

// @lc code=start
class Solution {
    // abccba
    // abcba
    // 只有一个奇数字符 或者 没有奇数字符
    public int longestPalindrome(String s) {
        int[] array = new int[60];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 'A']++;
        }
        int result = 0;
        for (int count : array) {
            if (count == 0) {
                continue;
            }
            result += count / 2 * 2;
            if (count % 2 == 1 && result % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
// @lc code=end
