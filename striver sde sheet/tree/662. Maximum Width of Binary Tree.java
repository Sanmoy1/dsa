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
 public class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode n,int i)
    {
        node=n;
        index=i;
    }
 }
class Solution {
    //time complexity: O(N)
    //space complexity: O(N)

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        Queue<Pair> queue=new LinkedList<>();
        int max=0;
        int index=1;
        queue.add(new Pair(root,index)) ;
        while(queue.isEmpty()!=true)
        {
            int size=queue.size();
            int firstIndex=queue.peek().index;
            int leftmost=0,rightmost=0;
            for(int i=0;i<size;i++)

            {
                Pair p=queue.poll();
                TreeNode node=p.node;
                int currentIndex=p.index-firstIndex;
                
                if(i==0)
                leftmost=currentIndex;
                if(i==(size-1))
                rightmost=currentIndex;
                if(node.left!=null)
                queue.add(new Pair(node.left,2*p.index));
                if(node.right!=null)
                queue.add(new Pair(node.right,2*p.index+1));
                
            }
            max=Math.max(max,rightmost-leftmost+1);
        }
        return max;
        

    }
}
 // the intution behind the above code:

//  Here is the BFS structure in steps (NO CODE):

// Create queue that stores (node, index)

// Push (root, 1) into queue

// While queue is not empty

// size = queue.size()

// firstIndex = index of first element

// Loop size times:

// Pop (node, index)

// Normalize index by subtracting firstIndex

// Track leftmost, rightmost

// Push children with updated indices

// Compute width = rightmost - leftmost + 1

// Update max

// Return max