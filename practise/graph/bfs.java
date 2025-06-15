class Solution {
    //time complexity O(V+E)
    // where v is the number of vertices and e is the number of edges
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> visited=new ArrayList<>();
        ArrayList<Integer> bfs=new ArrayList<>();
    
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty())
        {
            Integer node=queue.poll();
            bfs.add(node);
            
            for(Integer innerNode:adj.get(node))
            {
                if(!visited.contains(innerNode))
                    {
                        queue.add(innerNode);
                        visited.add(innerNode);
                    }
            }
        }
        return bfs;
    }
}