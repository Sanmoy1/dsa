class Solution {

    //brute force approach
    // time Complexity O((l2 - l1) l1 log l1)    
    boolean helper(String subs_s2, String s1) {
        char[] arr1 = subs_s2.toCharArray();
        char[] arr2 = s1.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2)
            return false;

        for (int left = 0; left <= l2 - l1; left++) {
            String window = s2.substring(left, left + l1);
            if (helper(window, s1)) {
                return true;
            }
        }
        return false;
    }

    // optimized approach
    // time complexity = O(l2)
    public boolean checkInclusion(String s1, String s2) {
            int l1 = s1.length(), l2 = s2.length();
            if (l1 > l2) return false;   // Edge case
    
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
    
            // Build frequency map for s1
            for (char ch : s1.toCharArray()) {
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            }
    
            // Build frequency map for the first window in s2
            for (int i = 0; i < l1; i++) {
                char ch = s2.charAt(i);
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }
    
            // Now slide the window
            for (int i = l1; i < l2; i++) {
                if (map1.equals(map2)) return true;  // Check current window
    
                // Add the new character (entering the window)
                char newChar = s2.charAt(i);
                map2.put(newChar, map2.getOrDefault(newChar, 0) + 1);
    
                // Remove the old character (leaving the window)
                char oldChar = s2.charAt(i - l1);
                map2.put(oldChar, map2.get(oldChar) - 1);
                if (map2.get(oldChar) == 0) {
                    map2.remove(oldChar); // cleanup to keep maps comparable
                }
            }
    
            // Final check for the last window
            return map1.equals(map2);
        }
    
    

}