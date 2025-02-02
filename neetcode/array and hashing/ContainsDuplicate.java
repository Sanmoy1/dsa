//https://leetcode.com/problems/contains-duplicate/



//down below is the brute force approach to solve the problem.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int l=nums.length;
        for (int i=1;i<l;i++)
        {
            for (int j=0;j<i;j++)
            {
                if(nums[i]==nums[j])
                {
                    return true;
                    
                }
                
            }
        }
        return false;
    }
}


// this is the optimized solution using sorting
// We can even sort the given array and check the previous elements if they are equal or not.
// time complexity is O(nlogn) and space complexity is O(1)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            return true;
        }
        return false;
    }
}
