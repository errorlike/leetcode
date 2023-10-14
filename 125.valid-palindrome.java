/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.cn/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (46.56%)
 * Likes:    702
 * Dislikes: 0
 * Total Accepted:    512.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.trim().length() == 0) {
            return true;
        }
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            char start = s.charAt(left);
            char end = s.charAt(right);
            if (!Character.isLetterOrDigit(start)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                right--;
                continue;
            }
            if (start != end) {
                return false;
            } else {
                left++;
                right--;
            }

        }
        return true;
    }
}
// @lc code=end
