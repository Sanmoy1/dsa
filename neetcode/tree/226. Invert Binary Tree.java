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

 // time complexity: O(N)
 // space complexity: O(N)
class Solution {
    void helper(Queue<TreeNode> queue)
    {
        if(queue.isEmpty()==true)
        {
            return;
        }
        TreeNode currentNode=queue.poll();

        TreeNode temp=currentNode.left; //this is nothing but just like swapping 2 variables
        currentNode.left=currentNode.right;
        currentNode.right=temp;
        
        if(currentNode.left!=null)

        queue.add(currentNode.left);
        if(currentNode.right!=null)
        queue.add(currentNode.right);
        helper(queue);       
        
    }

    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
        return root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);        
        helper(queue);
        return root;

    }
}