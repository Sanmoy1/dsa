class Solution {
    //Time complexity is O(n^2)
    // time limit exceeded
    //counting the left max and right max at the current index
    // if the check is negative then at index 0 it will not be able to store water at all
    
    
    public int trap(int[] height) {
        int max=0;
        int l=height.length;
        for(int i=0;i<l;i++)
        {
            int c=0;
            int leftMax=0;
            while(c<i)
            {
               if(leftMax<height[c])
               leftMax=height[c];
               c++;
            }
            int c1=l-1;
            int rightMax=0;
            while(c1>i)
            {
                if(rightMax<height[c1])
                rightMax=height[c1];
                c1--;
            }
            int check=Math.min(leftMax,rightMax)-height[i];
            if(check>0)
            {
                max+=check;
            }
        }
        return max;
    }
}