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

 class Pair
{
    TreeNode node;
    int level;
    int column;
    public Pair(TreeNode _node, int _level,int _column )
    {
        node=_node;
        level=_level;
        column=_column;
    }
}

//time complexity: O(N log N)
//space complexity: O(N)
class Solution {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue=new LinkedList<Pair>();
        queue.offer(new Pair(root,0,0));
        while(!queue.isEmpty())
        {
            Pair pair=queue.poll();
            TreeNode node=pair.node;
            int level=pair.level;
            int column=pair.column;
            if(!map.containsKey(column))
            {
                map.put(column,new TreeMap<>());
            }
            if(!map.get(column).containsKey(level))
            {
                map.get(column).put(level,new PriorityQueue<>());
            }
            map.get(column).get(level).offer(node.val);
            if(node.left!=null)
            queue.offer(new Pair(node.left,level+1,column-1));
            if(node.right!=null)
            queue.offer(new Pair(node.right, level+1, column+1));
        }
        List<List<Integer>> list=new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {// stores all the columns
    List<Integer> col = new ArrayList<>();
    for (PriorityQueue<Integer> nodes : ys.values()) {// stores all the elements of the queue for all the levels
        while (!nodes.isEmpty()) 
        col.add(nodes.poll());// this will make sure the values is in ascending order
    }
    list.add(col);
}
        return list;

        
}
}