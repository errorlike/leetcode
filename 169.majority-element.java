/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.cn/problems/majority-element/description/
 *
 * algorithms
 * Easy (66.52%)
 * Likes:    2016
 * Dislikes: 0
 * Total Accepted:    789.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // 相当于一个从最左端滑倒最右端。始终覆盖的元素。
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
// @lc code=end
