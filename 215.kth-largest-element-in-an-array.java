/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (62.71%)
 * Likes:    2328
 * Dislikes: 0
 * Total Accepted:    943.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Given an integer array nums and an integer k, return the k^th largest
 * element in the array.
 * 
 * Note that it is the k^th largest element in the sorted order, not the k^th
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
// @lc code=end
