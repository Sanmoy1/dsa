import java.util.*;

import javax.print.attribute.standard.QueuedJobCount;

public class bfs {
    
    ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> visited=new ArrayList<>();
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty())
        {
            Integer node=queue.poll();
            bfs.add(node);
            for(Integer i:adj.get(node))
            {
                if(!visited.contains(i))
                {
                    queue.add(i);
                    visited.add(i);
                }
            }
        }

        return bfs;
    }

    
}
