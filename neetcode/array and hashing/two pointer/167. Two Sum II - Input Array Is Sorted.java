class Solution {
    //brute force approach
    //time complexity is O(n^2)


    public int[] twoSum(int[] numbers, int target) {
        int ans[]=new int[2];
        int l=numbers.length;
        for(int i=0;i<l-1;i++)
        {
            for(int j=i+1;j<l;j++)
            {
                if((numbers[i]+numbers[j])==target)
                {
                    ans[0]=i+1;
                    ans[1]=j+1;
                    return ans;
                }
            }
        }
        return ans;
    }

    //optimized approach
    // time complexity is O(n) and space complexity is O(1)
    // here we are using the concept of binary search as the array is sorted
    // if sum is greater than the target then reduce the right pointer else increase the left pointer


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int length = numbers.length;
        int right = length - 1;
        int ans[] = new int[2];
        while (left < right) {
            int sum=numbers[left] + numbers[right];

            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if(sum<target) {
                left++;
            }
            else
            {
                right--;
            }

        }
        return ans;
    }
}