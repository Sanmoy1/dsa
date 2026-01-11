// question:
// There is 2d Matrix of size h*w representing the city. Each cell can be 0,1,2,3,4 0-> road 1->Tree 2-> Garage 3-> warehouse 4-> Airport There is a truck parked at the garage. The truck's task is to go to the warehouse (one or many at a time) , load the goods and unload the truck at the airport. There is no limit on the number of goods a truck can carry. There is a cost associated with a truck. Cost is (Number of blocks it has moved * (1+Number of good truck carries)) like To move one block costs 1 on an empty truck Cost is 2 if the truck has 1 good 3 If the truck has 2 goods. . .You have to tell how many maximum goods can be unloaded at the airport using at max C cost q Constraints Number of test cases - 50 h,w belong to (2,40) c belongs to (5,2000) There can be at max 13 warehouses A truck cannot pass a tree. If it is at any warehouse truck can or cannot load the goods; similarly, if it's at an airport, it's not necessary to unload the goods. But the starting point is fixed ie, the garage


import java.io.*; // Import input-output classes
import java.util.*; // Import utility classes like Scanner, ArrayList, etc.

public class Main { // Main class definition

    static final int INF = 1_000_000_000; // Constant for Infinity to represent unreachable distance
    static int H, W, C; // Variables for Height, Width of grid, and Max Cost C
    static int[][] grid; // 2D array to store the city grid layout

    static int[] dx = {1, -1, 0, 0}; // Direction array for row movement (Down, Up)
    static int[] dy = {0, 0, 1, -1}; // Direction array for column movement (Right, Left)

    static List<int[]> nodes = new ArrayList<>(); // List to store coordinates of interest (Garage, Warehouses, Airports)
    static List<Integer> warehouseIndices = new ArrayList<>(); // List to store indices of warehouses in the 'nodes' list
    static List<Integer> airportIndices = new ArrayList<>(); // List to store indices of airports in the 'nodes' list

    static int[][] dist; // Adjacency matrix to store shortest path distances between all key nodes
    static int[][] dp; // DP table for state [mask][current_node_index] storing min cost

    static int warehouseCount; // Total number of warehouses found
    static int maxGoods; // Variable to track the maximum goods unloaded so far

    public static void main(String[] args) throws Exception { // Main method entry point
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Fast I/O reader
        StringBuilder out = new StringBuilder(); // StringBuilder to accumulate output

        int T = Integer.parseInt(br.readLine().trim()); // Read number of test cases

        while (T-- > 0) { // Loop through each test case
            StringTokenizer st = new StringTokenizer(br.readLine()); // Read H, W, C line
            H = Integer.parseInt(st.nextToken()); // Parse Height
            W = Integer.parseInt(st.nextToken()); // Parse Width
            C = Integer.parseInt(st.nextToken()); // Parse Cost Limit

            grid = new int[H][W]; // Initialize grid with H rows and W columns
            nodes.clear(); // Clear nodes list for new test case
            warehouseIndices.clear(); // Clear warehouse indices
            airportIndices.clear(); // Clear airport indices

            int garageIndex = -1; // Variable to store index of garage node

            for (int i = 0; i < H; i++) { // Loop through rows
                st = new StringTokenizer(br.readLine()); // Read row data
                for (int j = 0; j < W; j++) { // Loop through columns
                    grid[i][j] = Integer.parseInt(st.nextToken()); // Parse grid value
                    if (grid[i][j] == 2) { // Check if cell is Garage (2)
                        garageIndex = nodes.size(); // Store index of garage
                        nodes.add(new int[]{i, j}); // Add garage coordinates to nodes list
                    }
                }
            }

            // Add warehouses to nodes list
            for (int i = 0; i < H; i++) { // Loop rows
                for (int j = 0; j < W; j++) { // Loop columns
                    if (grid[i][j] == 3) { // Check if cell is Warehouse (3)
                        warehouseIndices.add(nodes.size()); // Store index in warehouseIndices
                        nodes.add(new int[]{i, j}); // Add to nodes list
                    }
                }
            }

            // Add airports to nodes list
            for (int i = 0; i < H; i++) { // Loop rows
                for (int j = 0; j < W; j++) { // Loop columns
                    if (grid[i][j] == 4) { // Check if cell is Airport (4)
                        airportIndices.add(nodes.size()); // Store index in airportIndices
                        nodes.add(new int[]{i, j}); // Add to nodes list
                    }
                }
            }

            warehouseCount = warehouseIndices.size(); // Count total warehouses
            int nodeCount = nodes.size(); // Total key nodes (Garage + Warehouses + Airports)

            dist = new int[nodeCount][nodeCount]; // Initialize distance matrix
            for (int i = 0; i < nodeCount; i++) { // For every key node
                Arrays.fill(dist[i], INF); // Initialize distances to INF
                bfs(i); // Run BFS to find shortest paths to all other nodes
            }

            int maxMask = 1 << warehouseCount; // 2^warehouseCount states for bitmask
            dp = new int[maxMask][nodeCount]; // Initialize DP table
            for (int i = 0; i < maxMask; i++) { // Loop through all masks
                Arrays.fill(dp[i], INF); // Initialize DP states to INF
            }

            dp[0][garageIndex] = 0; // Base case: cost at garage with 0 goods is 0
            maxGoods = 0; // Reset maxGoods

            dfs(0, garageIndex); // Start DFS from garage with empty mask

            out.append(maxGoods).append("\n"); // Append result for this test case
        }

        System.out.print(out); // Print all outputs
    }

    // BFS from node index to fill distance matrix
    static void bfs(int idx) {
        int[][] d = new int[H][W]; // Local distance grid for BFS
        for (int[] row : d) Arrays.fill(row, INF); // Initialize all cells to INF

        Queue<int[]> q = new ArrayDeque<>(); // Queue for BFS
        int sx = nodes.get(idx)[0]; // Source X coordinate
        int sy = nodes.get(idx)[1]; // Source Y coordinate

        q.add(new int[]{sx, sy}); // Add source to queue
        d[sx][sy] = 0; // Distance to source is 0

        while (!q.isEmpty()) { // While queue is not empty
            int[] cur = q.poll(); // Dequeue current cell
            int x = cur[0], y = cur[1]; // Get coordinates

            for (int k = 0; k < 4; k++) { // Try all 4 directions
                int nx = x + dx[k]; // New X
                int ny = y + dy[k]; // New Y

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue; // Check bounds
                if (grid[nx][ny] == 1) continue; // Check for Tree (obstacle) (1)
                if (d[nx][ny] > d[x][y] + 1) { // If shorter path found
                    d[nx][ny] = d[x][y] + 1; // Update distance
                    q.add(new int[]{nx, ny}); // Enqueue new cell
                }
            }
        }

        for (int j = 0; j < nodes.size(); j++) { // Store distances to other key nodes
            int tx = nodes.get(j)[0]; // Target X
            int ty = nodes.get(j)[1]; // Target Y
            dist[idx][j] = d[tx][ty]; // Update dist matrix with shortest path distance
        }
    }

    // DFS + DP (memoized) to explore paths
    static void dfs(int mask, int u) {
        int currentCost = dp[mask][u]; // Get current cost for this state
        if (currentCost > C) return; // Prune if cost exceeds limit C

        int goods = Integer.bitCount(mask); // Count number of collected goods

        // Try unloading at any airport
        for (int a : airportIndices) { // Loop through all airports
            if (dist[u][a] == INF) continue; // If airport unreachable, skip
            int moveCost = dist[u][a] * (1 + goods); // Calculate moving cost: dist * (1 + goods)
            if (currentCost + moveCost <= C) { // If total cost within limit
                maxGoods = Math.max(maxGoods, goods); // Update maxGoods result
            }
        }

        // Try collecting new warehouse
        for (int i = 0; i < warehouseCount; i++) { // Loop through all warehouses
            if ((mask & (1 << i)) != 0) continue; // If already visited this warehouse, skip

            int wNode = warehouseIndices.get(i); // Get actual node index of warehouse
            if (dist[u][wNode] == INF) continue; // If unreachable, skip

            int moveCost = dist[u][wNode] * (1 + goods); // Calculate travel cost to warehouse
            int newCost = currentCost + moveCost; // New accumulated cost
            if (newCost > C) continue; // Prune if exceeds limit

            int newMask = mask | (1 << i); // Create new mask with this warehouse bit set
            if (newCost < dp[newMask][wNode]) { // If found cheaper path to this state
                dp[newMask][wNode] = newCost; // Update DP table
                dfs(newMask, wNode); // Recurse with new state
            }
        }
    }
}
