/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.cn/problems/insert-interval/description/
 *
 * algorithms
 * Medium (42.65%)
 * Likes:    840
 * Dislikes: 0
 * Total Accepted:    182.2K
 * Total Submissions: 427.2K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the i^th
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^5
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        int i = 0;
        
        // 添加新区间，左侧的区间
        //intervals[i][1]是右侧
        while (i < intervals.length && intervals[i][1] < left) {
            result.add(intervals[i]);
            i++;
        }

        // intervals[i][0]是左侧。
        // 合并重叠部分
        while (i < intervals.length && intervals[i][0] <= right) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // 如果有，将剩下的区间加入结果集
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

}
// @lc code=end
