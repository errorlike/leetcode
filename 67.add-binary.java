/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.cn/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.89%)
 * Likes:    1120
 * Dislikes: 0
 * Total Accepted:    353.7K
 * Total Submissions: 668.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * 
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 * 
 * 
 */

// @lc code=start
class Solution {
    // 方法一，逆向遍历字符串。此时拼接的结果字符串与答案是反向的。
    // 计算过程中需要记录进位。
    // 计算过程 (a + b + carry) % 2 newcarry = result /2
    // 两个字符串不等长。则依然需要添加长字符串的剩余部分。
    // 如果连个字符串之和超过两个字符串中最长的长度.需要添加最后的carry。
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int aBit = 0;
            int bBit = 0;
            if (i >= 0) {
                aBit = a.charAt(i) - '0';
            }
            if (j >= 0) {
                bBit = b.charAt(j) - '0';
            }
            stringBuilder.append((aBit + bBit + carry) % 2);
            carry = (aBit + bBit + carry) / 2;
        }
        stringBuilder.append(carry == 1 ? carry : "");
        return stringBuilder.reverse().toString();
    }
}
// @lc code=end
