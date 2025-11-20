/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;

        // If node violates the min/max constraint
        if (root.val <= min || root.val >= max) return false;

        // Left subtree → max becomes root.val
        // Right subtree → min becomes root.val
        return helper(root.left, min, root.val) && 
               helper(root.right, root.val, max); // the && saves time if the left subtree returns false then it will not check the right substree
    }
    public boolean isValidBST(TreeNode root) {
        boolean ans=helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return ans;
        
    }
}