// question: https://www.youtube.com/watch?v=GS_OqZb2CWc
import java.util.*;

public class MinSubsetSumDifference {

    static int[][] dp;

    // f(index, target) = 1 if we can form 'target' sum using arr[0..index]
    static boolean f(int[] arr, int index, int target) {
        if (target == 0) return true; // sum 0 always possible
        if (index == 0) return arr[0] == target; // base case at 0

        if (dp[index][target] != -1) return dp[index][target] == 1;

        // Choice 1: take current element (if target allows)
        boolean take = false;
        if (arr[index] <= target) {
            take = f(arr, index - 1, target - arr[index]);
        }

        // Choice 2: don't take current element
        boolean notTake = f(arr, index - 1, target);

        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public static int minDifference(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        for (int x : arr) totalSum += x;

        int dp = new int[n][totalSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int minDiff = Integer.MAX_VALUE;

        // Try all possible sums for one subset up to totalSum/2
        for (int s = 0; s <= totalSum / 2; s++) {
            if (f(arr, n - 1, s)) {
                int diff = totalSum - 2 * s;
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minDifference(arr)); // Output: 1
    }
}
