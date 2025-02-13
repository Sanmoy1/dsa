//https://leetcode.com/problems/two-sum/description/

//brute force approach
//time complexity is O(n^2) and space complexity is O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=1;i<nums.length;i++)
        {
            for (int j=0;j<i;j++)
            {
                if((nums[j]+nums[i])== target)
                {
                    return new int[]{i,j};
                }
                
            }
        }
        return new int[0];
    }
}

//optimized approach using hashing where we store the current number and its index in a hashmap
//time complexity is O(n) and space complexity is O(n)

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> map = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            int otherNumber = target - nums[i];
            if (map.containsKey(otherNumber)) {
                return new int[] { map.get(otherNumber), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }
}

