//https://leetcode.com/problems/two-sum/description/

//brute force approach

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


