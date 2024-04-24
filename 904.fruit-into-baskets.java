/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] Fruit Into Baskets
 *
 * https://leetcode.cn/problems/fruit-into-baskets/description/
 *
 * algorithms
 * Medium (44.94%)
 * Likes:    636
 * Dislikes: 0
 * Total Accepted:    163K
 * Total Submissions: 362.6K
 * Testcase Example:  '[1,2,1]'
 *
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the i^th tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * 
 * 
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * 
 * 
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees
 * [1,2].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * 
 * 
 */

// @lc code=start
//  目标：找出只有两种类型的最长连续数组。
//  使用动态的滑动窗口。

import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int start = 0;
        var typeMap = new HashMap<Integer, Boolean>();
        for (int end = 0; end < fruits.length; end++) {
            // 该窗口中添加两种不同的类型
            int type = fruits[end];
            if (typeMap.size() < 2 && !typeMap.getOrDefault(type, false)) {
                typeMap.put(type, true);
                max = Math.max(max, end - start + 1);
                // 获得的水果数比较。
            } else if (typeMap.getOrDefault(type, false)) {
                max = Math.max(max, end - start + 1);
                // 添加新窗口
            } else {
                typeMap = new HashMap<Integer, Boolean>();
                start = end - 1;
                typeMap.put(fruits[start], true);
                typeMap.put(type, true);
            }
            // 回溯start指针
            while (start > 0 && fruits[start] == fruits[start - 1]) {
                start--;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
// @lc code=end
