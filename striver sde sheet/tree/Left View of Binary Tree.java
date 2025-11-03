/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
//TIME COMPLEXITY = O(N)
//SPACE COMPLEXITY = O(height of tree)
class Solution {
    void helper(Node root,ArrayList<Integer> arr,int level)
    {
        if(root==null)
        {
            return;
        }
        if(level==arr.size())
        arr.add(root.data);
        helper(root.left,arr,level+1);// we use the pre order traversal to get the left view
        helper(root.right,arr,level+1);
        
    }
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        helper(root,arr,0);
        return arr;
    }
}