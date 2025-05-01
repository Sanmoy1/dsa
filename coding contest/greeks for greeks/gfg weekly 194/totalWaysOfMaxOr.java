public class totalWaysOfMaxOr {
    class Solution {
        public int totalWays(int n) {
            // First find the maximum OR value possible
            int maxOr = 0;
            for(int x = 0; x <= n; x++) {
                maxOr = Math.max(maxOr, x | n);
            }
            
            // Then count numbers that give this maximum OR value
            int count = 0;
            for(int x = 0; x <= n; x++) {
                if((x | n) == maxOr) {
                    count++;
                }
            }
            
            return count;
        }
    }
}