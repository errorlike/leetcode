/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.cn/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (43.10%)
 * Likes:    326
 * Dislikes: 0
 * Total Accepted:    122.1K
 * Total Submissions: 283.3K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error
 * less than 10^-5 will be accepted.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= k <= n <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // 当end=nums.length的时候循环停止。
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < nums.length; end++) {
            // 计算和。
            sum += nums[end];
            if (end - start == k - 1) {
                max = Math.max(sum, max);
                sum -= nums[start];
                start += 1;
            }
        }
        return 1.0 * max / k;
    }
}
// @lc code=end
