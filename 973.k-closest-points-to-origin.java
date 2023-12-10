/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode.cn/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Medium (65.28%)
 * Likes:    404
 * Dislikes: 0
 * Total Accepted:    97.8K
 * Total Submissions: 149.8K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on
 * the X-Y plane and an integer k, return the k closest points to the origin
 * (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be
 * unique (except for the order that it is in).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= points.length <= 10^4
 * -10^4 <= xi, yi <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    // 最近的K个点，大顶堆。
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return distance(o2) - distance(o1);
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(points[i]);
        }

        for (int j = k; j < points.length; j++) {
            if (distance(priorityQueue.peek()) > distance(points[j])) {
                priorityQueue.poll();
                priorityQueue.offer(points[j]);
            }
        }
        return priorityQueue.toArray(new int[k][]);
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
// @lc code=end
