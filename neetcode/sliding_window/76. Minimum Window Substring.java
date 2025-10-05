class Solution {
    
    //semi optimal code

    public String minWindow(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (l1 < l2) return "";

        HashMap<Character, Integer> map_s = new HashMap<>();
        HashMap<Character, Integer> map_t = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map_t.put(ch, map_t.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String minString = "";

        for (int i = 0; i < l1; i++) {
            char ch = s.charAt(i);
            map_s.put(ch, map_s.getOrDefault(ch, 0) + 1);

            // shrink window if valid
            while (map_s.keySet().containsAll(map_t.keySet()) && check(map_s, map_t)) {
                if (i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    minString = s.substring(left, i + 1);
                }

                char leftChar = s.charAt(left);
                map_s.put(leftChar, map_s.get(leftChar) - 1);
                if (map_s.get(leftChar) == 0)
                    map_s.remove(leftChar);

                left++;
            }
        }

        return minString;
    }

    // Helper: checks if map_s covers map_t
    private boolean check(HashMap<Character, Integer> map_s, HashMap<Character, Integer> map_t) {
        for (char c : map_t.keySet()) {
            if (map_s.getOrDefault(c, 0) < map_t.get(c))
                return false;
        }
        return true;
    }


    
    // optimal code
    // time complexity = O(n)
    public String minWindow(String s, String t) {
            if (s.length() == 0 || t.length() == 0) return "";
    
            // Step 1: Count the frequency of each character in t
            HashMap<Character, Integer> mapT = new HashMap<>();
            for (char c : t.toCharArray()) {
                mapT.put(c, mapT.getOrDefault(c, 0) + 1);
            }
    
            // Number of unique chars in t that need to be present in window
            int required = mapT.size();
    
            // Left and right pointers
            int l = 0, r = 0;
    
            // To track how many unique chars in the current window match the required frequency
            int formed = 0;
    
            // Current window character count
            HashMap<Character, Integer> windowCounts = new HashMap<>();
    
            // ans[0] = window length, ans[1] = left, ans[2] = right
            int[] ans = {-1, 0, 0};
    
            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
    
                // If the frequency of the current char matches the desired count in t
                if (mapT.containsKey(c) && windowCounts.get(c).intValue() == mapT.get(c).intValue()) {
                    formed++;
                }
    
                // Try to contract the window till it's no longer 'desirable'
                while (l <= r && formed == required) {
                    char ch = s.charAt(l);
    
                    // Save the smallest window
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }
    
                    // Remove the leftmost character
                    windowCounts.put(ch, windowCounts.get(ch) - 1);
                    if (mapT.containsKey(ch) && windowCounts.get(ch).intValue() < mapT.get(ch).intValue()) {
                        formed--;
                    }
    
                    l++;
                }
    
                // Expand the window
                r++;
            }
    
            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }
    
}
