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

    // Time complexity is O(n)
    //Space complexity is O(n)
    //counting the left max and right max at the current index using 2 arrays with individial loops
    public int trap(int[] height) {
        int l=height.length; 
        int leftMax[]=new int[l];
        int rightMax[]=new int[l];
         leftMax[0]=height[0];
         for(int i=1;i<l;i++)
         {
            if(leftMax[i-1]<height[i])
            {
                leftMax[i]=height[i];
            }
            else
            {
                leftMax[i]=leftMax[i-1];
            }
         }
         rightMax[l-1]=height[l-1];
         for(int i=l-2;i>=0;i--)
         {
            if(rightMax[i+1]<height[i])
            {
                rightMax[i]=height[i];
            }
            else
            {
                rightMax[i]=rightMax[i+1];
            }
         }
         int count=0;
         for(int i=0;i<l;i++)
         {
            int check=Math.min(leftMax[i],rightMax[i])-height[i];
            if(check>0)
            count+=check;
         }
         return count;
    }
}