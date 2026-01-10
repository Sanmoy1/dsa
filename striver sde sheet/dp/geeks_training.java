// question: https://www.geeksforgeeks.org/problems/geeks-training/1

// User function Template for Java

class Solution {
    int f(int arr[][],int index,int dp[][],int last)
    {
        if(index<0)
        return 0;
        if(dp[index][last]!=-1)
        return dp[index][last];
        int max=0;
        for(int i=0;i<=2;i++)
        {
            if(i!=last)
            {
                int ans=arr[index][i]+f(arr,index-1,dp,i);
                max=Math.max(max,ans);
            }
        }
        dp[index][last]=max;
        return dp[index][last];
    }
    
    
    public int maximumPoints(int arr[][]) {
        // code here
        int l=arr.length;
        int dp[][]=new int[l][4];
        for(int i=0;i<l;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(arr,l-1,dp,3);
    }
}