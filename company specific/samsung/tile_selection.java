// question: Q2. Given N tiles of given width and height, we have to select K out of it, we need to 
// minimise the maximum of the difference between any two tiles selected, the 
// difference between any two tiles is defined as the maximum of the height difference 
// and width difference. 

import java.io.*; // Import java.io package for Buffered Reader and Input Stream Reader
import java.util.*; // Import java.util package for StringTokenizer

public class Main { // Main class definition

    static final int MAX = 400; // Define maximum coordinate value as 400
    static int[][] prefix = new int[MAX + 1][MAX + 1]; // Declare a 2D array for prefix sums with size MAX+1 x MAX+1

    public static void main(String[] args) throws Exception { // Main method which throws Exception for I/O errors

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Initialize BufferedReader to read input from console
        StringTokenizer st = new StringTokenizer(br.readLine()); // Read the first line of input and tokenize it

        int n = Integer.parseInt(st.nextToken()); // Parse the first token as integer N (number of tiles)
        int k = Integer.parseInt(st.nextToken()); // Parse the second token as integer K (number of tiles to select)

        // Frequency grid to store the count of tiles at each (width, height)
        int[][] freq = new int[MAX + 1][MAX + 1]; // Initialize frequency array

        for (int i = 0; i < n; i++) { // Loop N times to read each tile's dimensions
            st = new StringTokenizer(br.readLine()); // Read the next line of input
            int w = Integer.parseInt(st.nextToken()); // Parse width of the tile
            int h = Integer.parseInt(st.nextToken()); // Parse height of the tile
            freq[w][h]++; // Increment the frequency count for this (width, height)
        }

        // Build 2D prefix sum array to allow O(1) range sum queries
        for (int i = 0; i <= MAX; i++) { // Iterate through all rows from 0 to MAX
            for (int j = 0; j <= MAX; j++) { // Iterate through all columns from 0 to MAX
                prefix[i][j] = freq[i][j]; // Start with the frequency at the current cell
                if (i > 0) prefix[i][j] += prefix[i - 1][j]; // Add the prefix sum from the cell above (if valid)
                if (j > 0) prefix[i][j] += prefix[i][j - 1]; // Add the prefix sum from the cell to the left (if valid)
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1]; // Subtract the top-left diagonal overlap to avoid double counting
            }
        }

        // Binary search on the answer (the minimum maximum difference)
        int low = 0, high = MAX, ans = MAX; // Initialize binary search range [0, MAX] and answer

        while (low <= high) { // Continue binary search while the range is valid
            int mid = (low + high) / 2; // Calculate the middle value of the current range
            if (canSelect(mid, k)) { // Check if it's possible to select K tiles with max difference <= mid
                ans = mid; // If possible, update answer to mid (potential minimum)
                high = mid - 1; // Try to find a smaller possible difference in the lower half
            } else { // If not possible
                low = mid + 1; // Search in the upper half for a larger difference
            }
        }

        System.out.println(ans); // Print the final minimum maximum difference found
    }

    // Function to check if there exists a square of size d x d containing at least k points
    // A square of size d corresponds to max difference d in both dimensions.
    static boolean canSelect(int d, int k) { // Takes difference 'd' and required count 'k'
        for (int i = 0; i + d <= MAX; i++) { // Iterate through possible starting row indices i
            for (int j = 0; j + d <= MAX; j++) { // Iterate through possible starting column indices j
                int x1 = i, y1 = j; // Define top-left coordinates of the square (technically bottom-left in terms of indices)
                int x2 = i + d, y2 = j + d; // Define bottom-right coordinates of the square

                // Calculate number of points in the rectangle defined by (x1, y1) and (x2, y2)
                int count = prefix[x2][y2]; // Start with prefix sum at bottom-right corner
                if (x1 > 0) count -= prefix[x1 - 1][y2]; // Subtract the area above the rectangle
                if (y1 > 0) count -= prefix[x2][y1 - 1]; // Subtract the area to the left of the rectangle
                if (x1 > 0 && y1 > 0) count += prefix[x1 - 1][y1 - 1]; // Add back the top-left overlap which was subtracted twice

                if (count >= k) return true; // If count is at least k, condition is satisfied, return true
            }
        }
        return false; // If no such square is found after checking all positions, return false
    }
}
