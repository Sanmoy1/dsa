//https://leetcode.com/problems/maximum-score-after-splitting-a-string

//time complexity is O(n)

//we are counting the 1's to avoid nested loops. So we will be counting the 0s in the next loop and removing count of 1s '1' is encountered

public class prefix{

    public int maxScore(String s) {
        int zeros=0;
        int ones=0;
        int max=zeros+ones;
        int l=s.length();
        for (int i=0;i<l;i++)
        {
            if (s.charAt(i)=='1')
            ones++;
        }
        for(int i=0;i<l-1;i++)
        {
            if(s.charAt(i)=='0')
            zeros++;
            else if(s.charAt(i)=='1')
            ones--;
            max=((zeros+ones)>max)?zeros+ones:max;


        }
        return max;
        
    }

    

}