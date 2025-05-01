public class totalScoreOfMaxOr {
    class Solution {
        public int totalScore(int n) {
            final int MOD = 1000000007;
            
            // Find the highest set bit in n
            int highestBit = 31 - Integer.numberOfLeadingZeros(n);
            
            // The maximum OR value will be when we set all bits
            // from 0 to the highest set bit in n
            int maxOr = (1 << (highestBit + 1)) - 1;
            
            // For each number from n downwards
            long sum = 0;
            for(int x = n; x >= 0; x--) {
                // If this number gives maxOr when OR'd with n
                if((x | n) == maxOr) {
                    sum = (sum + x) % MOD;
                }
                // If we find a number that doesn't give maxOr
                // all smaller numbers won't give maxOr either
                else if((x | n) < maxOr) {
                    break;
                }
            }
            
            return (int)sum;
        }
    }
}