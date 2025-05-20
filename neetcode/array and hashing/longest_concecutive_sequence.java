import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longest_concecutive_sequence {

    // First sort then use a counter to check the length and another counter to
    // check the max
    // print the max
    // Complexity is O(nlogn)

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int currentStreak = 1;
        int longestStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Skip duplicates
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }

    // here we are using hashset to avoid duplicates
    // we go through the hashset and look for n-1 and if it is not there we go through the hashset and check if n+1 is there
    // time complexity is O(n)

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {//we use hashset to avoid duplicates and TLE
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {// this is mostly constant checks therefore O(1) for this loop
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;        
    }   

}
