// question: Q2. There is a company that issues gift certificates every day. The company will 
// apply the following rules to the gift certificates. - A gift certificate is printed with its own serial number which is made up of only 
// numbers. So, all gift certificates will have different serial numbers. - The digit sum of a serial number is S. Gift certificates issued on the same day 
// have the same S. 
// The maximum value of a serial number is A, and its number of digits is N. (For 
// example, if A = 34567, N is 5). 
 
// Given A and S for gift certificates to be issued on a day, you are required to write a 
// program that calculates the maximum issuable number of gift certificates 
 
// The calculated result may be too big. So, print the answer modulo 10^9 + 7. 
// You may increase the number from 1 to A by 1 and compare S with the sum of all 
// digits. However, this method cannot be used because the given A can be too large. 
// So you are required to write a more efficient program. 
// Examples:  
// 1. A = 101, S = 3, Answer: 4 
// Explanation: 21, 12, 3, and 30 can be made. As up to 101 can be made, 102 
// cannot be made 
// 2. A = 172, S = 3, Answer: 7 
// Explanation: 3, 12, 21, 30, 102, 111, and 120 can be made 
// 3. A = 50, S = 4, Answer 5 
// Explanation: 4, 40, 13, 31, and 22 can be made. 
// 4. A = 999 , S = 500 , Answer 0 
// Explanation: The maximum digit sum is 27. No gift certificate that meets the 
// condition of S = 500 can be issued 
// Constraints: 1 <= A < 10^100, 1 <= S <= 1000

import java.util.Arrays;

public class GiftCertificateDP {

    // Modulo as required
    static final int MOD = 1000000007;

    // Stores digits of A
    static char[] digits;

    // dp[index][sum] is used when tight == 0
    static long[][] dp;

    // Length of number A
    static int N;

    // Required digit sum
    static int S;

    public static void main(String[] args) {

        // Example inputs (you can change these)
        String A = "172";
        S = 3;

        digits = A.toCharArray();
        N = digits.length;

        // Initialize DP table with -1 (means not computed)
        dp = new long[N][S + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start DP from position 0, sum = 0, tight = true
        long result = solve(0, 0, true);

        // Exclude 0 if S == 0 (because problem counts from 1 to A)
        if (S == 0) {
            result = (result - 1 + MOD) % MOD;
        }

        System.out.println("Answer: " + result);
    }

    /**
     * Digit DP function
     *
     * @param pos   Current digit position (0 to N-1)
     * @param sum   Sum of digits used so far
     * @param tight Whether prefix is equal to A or already smaller
     * @return Number of valid numbers from this state
     */
    static long solve(int pos, int sum, boolean tight) {

        // If sum exceeds S, no valid number possible
        if (sum > S) {
            return 0;
        }

        // If all digits processed
        if (pos == N) {
            // Check if digit sum equals S
            return (sum == S) ? 1 : 0;
        }

        // If not tight and already computed, reuse result
        if (!tight && dp[pos][sum] != -1) {
            return dp[pos][sum];
        }

        long ans = 0;

        // Maximum digit we can place
        int limit = tight ? digits[pos] - '0' : 9;

        // Try all possible digits at current position
        for (int d = 0; d <= limit; d++) {

            // Update tight condition
            boolean newTight = tight && (d == limit);

            ans = (ans + solve(pos + 1, sum + d, newTight)) % MOD;
        }

        // Store result only when tight == false
        if (!tight) {
            dp[pos][sum] = ans;
        }

        return ans;
    }
}
