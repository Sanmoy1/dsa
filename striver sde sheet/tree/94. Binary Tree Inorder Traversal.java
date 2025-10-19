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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> arr = new ArrayList<>();
            if (root == null) return arr;

            arr.addAll(inorderTraversal(root.left));
            arr.add(root.val); // add the root value to the arraylist
            arr.addAll(inorderTraversal(root.right));

            return arr;      
        }
    }


    //this is the optimal code
    //time complexity = O(n)
    public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, arr);
        return arr;
    }

    private void helper(TreeNode node, List<Integer> arr) {
        if (node == null) return;

        helper(node.left, arr);
        arr.add(node.val);
        helper(node.right, arr);
    }
}