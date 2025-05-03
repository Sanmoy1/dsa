//https://leetcode.com/problems/product-of-array-except-self/description/

// we can use 2 arrays to store the left and right products and then multiply them to get the final answer

//time complexity is O(n) and space complexity is O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++)//left array
        { 
            left[i]=nums[i-1]*left[i-1];
        }
        right[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)//right array
        {
            right[i]=nums[i+1]*right[i+1];
        }
        for(int i=0;i<nums.length;i++)//ans array
        {
            ans[i]=left[i]*right[i];
        }


        return ans;
    }
}
