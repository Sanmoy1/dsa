import java.util.*;
public class test{
    int fibo(int n,int dp[])
    {
        if(n<=1)
        return n;
        if(dp[n]!=-1)
        {
            return dp[n];// display the precomputed sub problem
        }        
        
        dp[n]=fibo(n-1,dp)+fibo(n-2,dp);// we store the value if not computed previously
        return dp[n];
    }
    void print(int n,int dp[])
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(fibo(i,dp)+" ");
        }
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
        System.out.println(obj.fibo(n,dp));
        obj.print(n,dp);

    }
}