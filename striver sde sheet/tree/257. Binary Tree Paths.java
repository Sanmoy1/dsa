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
    void helper(TreeNode root,List<String> arr,String path)
    {
        
        
        if(root==null)
        {
            
            return;
        }
        if(path.length()==0)
        path+=root.val;
        else
        {
            path=path+"->"+root.val;

        }
        if(root.left==null && root.right==null)
        arr.add(path);
        helper(root.left,arr,path);
        helper(root.right,arr,path);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr=new ArrayList<>();
        helper(root,arr,"");
        return arr;
    }
}