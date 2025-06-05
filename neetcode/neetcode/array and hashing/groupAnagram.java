//https://leetcode.com/problems/group-anagrams/description/

//brute force approach
//time complexity is O(n^2) and space complexity is O(n)
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!used[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(group);
        }
        return result;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}


//optimized approach using hashmap
//time complexity is O(n*m)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        
        for(String s:strs)
        {
            int count[]=new int[26];
            for(char c:s.toCharArray())
            {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());//creating a new list for each key
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());


    }

}


