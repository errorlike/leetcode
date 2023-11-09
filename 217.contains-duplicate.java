/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] Contains Duplicate
 *
 * https://leetcode.cn/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (54.98%)
 * Likes:    1059
 * Dislikes: 0
 * Total Accepted:    827.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    // 使用hashset.将首次出现的元素放入set,如果放入失败就true,否则遍历完成false。
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
