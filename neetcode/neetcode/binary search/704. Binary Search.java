// O(logn) time complexity
class Solution {
    public int search(int[] nums, int target) {
        int l=nums.length;
        int left=0;
        int right= l-1;
        int middle;
        while(left<=right)
        {
            middle=(left+right)/2;
            if(target<nums[middle])
            right=middle-1;
            else if(target>nums[middle])
            left=middle+1;
            else if(target==nums[middle])
            return middle;
        }
        return -1;
    }
}