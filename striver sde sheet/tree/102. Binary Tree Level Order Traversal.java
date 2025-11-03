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
import java.util.*;

import javax.swing.tree.TreeNode;
//TIME COMPLEXITY = O(N)
//SPACE COMPLEXITY = O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
        {
            return arr;
        }
        queue.add(root);
        while(queue.isEmpty()!=true)
        {
            List<Integer> arr2 = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                arr2.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            arr.add(arr2);
            
        }
        return arr;

    }
}

//write the recursion version of the code here:
class SolutionRecursive {
    //TIME COMPLEXITY = O(N)
    //SPACE COMPLEXITY = O(height of tree)
    class SolutionRecursive {
    // TIME: O(N), SPACE: O(height)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int depth, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        helper(node.left, depth + 1, res);
        helper(node.right, depth + 1, res);
    }
}
}
