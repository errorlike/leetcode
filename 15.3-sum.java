/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.cn/problems/3sum/description/
 *
 * algorithms
 * Medium (37.49%)
 * Likes:    6569
 * Dislikes: 0
 * Total Accepted:    1.6M
 * Total Submissions: 4.2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1:
 * 15.3-sum.java
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 将三数之和的问题降阶成降阶成两数之和的问题
    // 数组排序，循环中的每个值作为基准值。
    // 重复值处理：找到第一个不重复的值作为基准值。
    /*
     * 边界条件： nums.length-2 避免 左右指针越界,如果是 0，0，0这种情况需不需要再进行处理,保证left<right和先求和就不需要处理
     * 需要保持base, left ,right的顺序
     * 如果最小值>0 则result 为[]。
     * 如果等于0 ，则添加，并且移动左右指针到第一个不同的地方。
     * 小于0，则移动左指针到第一个不为重复的地方。大于零则移动右指针到第一个不重复的地方。
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int base = 0; base < nums.length - 2; base++) {
            if (nums[base] > 0) {
                return result;
            }
            // 保证新的base和之前不同
            if (base > 0 && nums[base] == nums[base - 1]) {
                continue;
            }
            int left = base + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[base] + nums[left] + nums[right];
                if (sum < 0) {
                    // 更换不同的left while (left < right && nums[left] == nums[++left])
                    ;

                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right])
                        ;
                } else {
                    result.add(Arrays.asList(nums[base], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left])
                        ;
                    while (left < right && nums[right] == nums[--right])
                        ;

                }

            }
        }
        return result;
    }
}
// @lc code=end
