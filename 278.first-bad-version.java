/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] First Bad Version
 *
 * https://leetcode.cn/problems/first-bad-version/description/
 *
 * algorithms
 * Easy (45.42%)
 * Likes:    989
 * Dislikes: 0
 * Total Accepted:    480.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '5\n4'
 *
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all
 * the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the
 * first bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, bad = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= bad <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// 如果mid为true ,从右边找错误
// 如果mid为false,从左边找到错误
// 临界值 左边为ture的第一个false。
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }
}
// @lc code=end
