// question:
// You are given N goods in a warehouse.
// Each good has an initial stock and a fixed daily increment.

// Every day:

// The stock of each good increases by its daily increment.

// You may export exactly one good, setting its stock to 0.

// Given an integer K, determine the minimum number of days required such that the total stock of all goods is ≤ K.
// If it is not possible, return −1.

// Example
// Input
// Initial stock:   [5, 3, 4]
// Daily increment: [1, 1, 1]
// K = 6

// Explanation

// Day 1

// After increment → [6, 4, 5]

// Export the largest stock (6) → [0, 4, 5]

// Total = 9

// Day 2

// After increment → [1, 5, 6]

// Export the largest stock (6) → [1, 5, 0]

// Total = 6 ≤ K

// Output
// 2

import java.util.*;

public class WarehouseStock {

    // Function to find minimum days to reduce total stock <= K
    public static int minDaysToReduceStock(int[] A, int[] B, int K) {
        int n = A.length;
        long INF = Long.MAX_VALUE / 2; // avoid overflow

        int totalMasks = 1 << n;
        long[] dp = new long[totalMasks];
        Arrays.fill(dp, INF);

        // Base case: nothing exported yet
        long initialSum = 0;
        for (int i = 0; i < n; i++) initialSum += A[i];
        dp[0] = initialSum;

        for (int mask = 1; mask < totalMasks; mask++) {
            int days = Integer.bitCount(mask); // number of exports done

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    int prev = mask ^ (1 << i);

                    // Stock of item i at the day it is exported
                    long removedStock = A[i] + (long) days * B[i];

                    dp[mask] = Math.min(dp[mask], dp[prev] - removedStock);
                }
            }

            // Check if target reached
            if (dp[mask] <= K) {
                return days;
            }
        }

        // Impossible to reach target
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] A = {10, 20, 30}; // initial stock
        int[] B = {5, 1, 2};    // daily increase
        int K = 25;             // target total stock

        int result = minDaysToReduceStock(A, B, K);
        System.out.println("Minimum days required: " + result);
    }
}
