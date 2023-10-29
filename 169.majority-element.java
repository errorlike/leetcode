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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    // 统计出现次数。
    // 元素作为key, 出现次数作为value
    // 遍历找到最大的那个
    public Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        return map;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = countNums(nums);
        int maxKey = 0;
        int maxValue = 0;
        for (Entry<Integer, Integer> entrySet : countMap.entrySet()) {
            if (entrySet.getValue() > maxValue) {
                maxKey = entrySet.getKey();
                maxValue = entrySet.getValue();
            }
        }
        return maxKey;
    }
}
// @lc code=end
