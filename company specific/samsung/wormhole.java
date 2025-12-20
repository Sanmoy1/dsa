import java.util.*;

public class wormhole {
    static class Nodes {
        int x, y;
        Nodes(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;// stores the destination node
            this.cost = cost;// cost related to the travel
        }
    }

    // Helper to calculate Manhattan distance
    static int dist(Nodes n1, Nodes n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the inputs");
        
        if (!in.hasNext()) return;

        int sx = in.nextInt();
        int sy = in.nextInt();
        int dx = in.nextInt();
        int dy = in.nextInt();
        int N = in.nextInt();
        int total_nodes = 2 * N + 2;
        
        ArrayList<Nodes> allNodes = new ArrayList<>();
        allNodes.add(new Nodes(sx, sy));
        allNodes.add(new Nodes(dx, dy));
        
        Map<Integer, Integer> wormholeCosts = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int cost = in.nextInt();
            
            allNodes.add(new Nodes(x1, y1)); 
            allNodes.add(new Nodes(x2, y2)); 
            
            int u = 2 + 2 * i;
            wormholeCosts.put(u, cost); 
        }

        // Adjacency List: ArrayList of ArrayList of Edge
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(total_nodes);
        for(int i = 0; i < total_nodes; i++) {
            adj.add(new ArrayList<Edge>());
        }

        // 1. Add Walking Edges (Complete Graph)
        for (int i = 0; i < total_nodes; i++) {
            for (int j = i + 1; j < total_nodes; j++) {
                int d = dist(allNodes.get(i), allNodes.get(j));
                adj.get(i).add(new Edge(j, d));
                adj.get(j).add(new Edge(i, d));
            }
        }

        // 2. Add Wormhole Edges
        // Note: In an adjacency list, we can have multiple edges between two nodes. 
        // Dijkstra will pick the best one automatically.
        for (Map.Entry<Integer, Integer> entry : wormholeCosts.entrySet()) {
            int u = entry.getKey();
            int v = u + 1;
            int cost = entry.getValue();
            
            adj.get(u).add(new Edge(v, cost));
            adj.get(v).add(new Edge(u, cost));
        }

        // Dijkstra with PriorityQueue
        int[] minInfo = new int[total_nodes];
        Arrays.fill(minInfo, Integer.MAX_VALUE);
        minInfo[0] = 0;

        // PQ stores {node, current_dist}
        // Use a simple int array or a custom class for PQ items
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > minInfo[u]) continue;
            if (u == 1) break; // Reached destination (index 1)

            for (Edge e : adj.get(u)) {
                if (minInfo[u] + e.cost < minInfo[e.to]) {
                    minInfo[e.to] = minInfo[u] + e.cost;
                    pq.add(new int[]{e.to, minInfo[e.to]});
                }
            }
        }
        
        System.out.println(minInfo[1]); 
    }
}