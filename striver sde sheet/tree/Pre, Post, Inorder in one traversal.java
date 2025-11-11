/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { 
 *         data = val; 
 *         left = null; 
 *         right = null; 
 *     }
 * }
 **/

import java.util.*;

class Solution {
    ArrayList<Integer> inorder = new ArrayList<>();
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();

    void helper(TreeNode root) {
        if (root == null)
            return;

        // Preorder: before traversing subtrees
        preorder.add(root.data);

        helper(root.left);

        // Inorder: after left, before right
        inorder.add(root.data);

        helper(root.right);

        // Postorder: after both subtrees
        postorder.add(root.data);
    }

    List<List<Integer>> treeTraversal(TreeNode root) {
        helper(root);  // <-- You forgot to call the helper

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(preorder);
        arr.add(inorder);
        arr.add(postorder);
        return arr;
    }
}
