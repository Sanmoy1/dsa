class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public static void helper(int node, ArrayList<Integer> dfs, ArrayList<Integer> visited, 
                                ArrayList<ArrayList<Integer>> adj)
    {
        visited.add(node);
                dfs.add(node);
                
        for (Integer i:adj.get(node))
        {
            if(!visited.contains(i))
            {
                
                helper(i,dfs,visited,adj);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> visited=new ArrayList<>();// we can also use boolean array to store visited nodes (boolean visited[]=new boolean[adj.size()])
        ArrayList<Integer> dfs=new ArrayList<>();
        visited.add(0);
        helper(0,dfs,visited,adj);
        return dfs;
    }
}