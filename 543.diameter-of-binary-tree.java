/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (59.15%)
 * Likes:    1429
 * Dislikes: 0
 * Total Accepted:    357.2K
 * Total Submissions: 603.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // 两个节点的之间的路径 = 两节点的深度之和。
    // 最短路径未必经过根节点。所以需要再计算过程中存储路径长度进行比较。
    // 节点的深度 = max(左子树深度，右子树深度)+
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxPath = new int[1]; 
        depth(root, maxPath);
        return maxPath[0];
    }

    public int depth(TreeNode root, int[] maxPath) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left, maxPath);
        int rightDepth = depth(root.right, maxPath);
        maxPath[0] = Math.max(maxPath[0], leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
// @lc code=end
