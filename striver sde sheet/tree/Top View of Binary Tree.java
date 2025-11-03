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
class Solution {
    
    static void dfs(Node node, int hd, int level, Map<Integer, int[]> topNodes) {
        if (node == null) return;

        // If horizontal distance is encountered for 
        // the first time or if it's at a higher level
        if (!topNodes.containsKey(hd) || topNodes.get(hd)[1] > level) {
            topNodes.put(hd, new int[]{node.data, level});
        }

        // Recur for left and right subtrees
        dfs(node.left, hd - 1, level + 1, topNodes);
        dfs(node.right, hd + 1, level + 1, topNodes);
    }
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Horizontal distance -> {node's value, level}
        TreeMap<Integer, int[]> topNodes = new TreeMap<>();

        // Start DFS traversal
        dfs(root, 0, 0, topNodes);

        // Collect nodes from the map
        for (Map.Entry<Integer, int[]> entry : topNodes.entrySet()) {
            result.add(entry.getValue()[0]);
        }

        return result;
    }
}