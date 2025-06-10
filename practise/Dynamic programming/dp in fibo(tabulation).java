import java.util.*;
public class test{
    // time cmplexity is O(n)
    //space complexity is O(n)
    void fibo(int n,int dp[])// dp in fibo using tabulation method
    {
        dp[0]=0;
        dp[1]=1;
        System.out.print(dp[0]+" "+dp[1]);
        
        for(int i=2;i<n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
            System.out.print(" " +dp[i]);
        }
        
    }
    // time cmplexity is O(n)
    //space complexity is O(1)
    // more optimised than the previous method
    void fibo(int n)
    {
        int prev=1;
        int prev2=0;
        for(int i=2;i<=n;i++)
        {
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        System.out.println(prev);
    }
    
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the number n:");
        int n=in.nextInt();
        test obj=new test();
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }
        obj.fibo(n, dp);

    }
}