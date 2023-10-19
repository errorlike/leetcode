/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] Balanced Binary Tree
 *
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (57.82%)
 * Likes:    1426
 * Dislikes: 0
 * Total Accepted:    547.3K
 * Total Submissions: 946.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
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
    public boolean isBalanced(TreeNode root) {
        if (getDepth(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth , rightDepth) + 1 : -1;
    }
}
// @lc code=end
