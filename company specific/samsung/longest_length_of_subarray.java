// question:
// Test - 3 
// You will be given a necklace having only red and blue stones in it. Your task is to 
// make the number of blue and red stones equal.  
// Stones can only be removed from either the left or right end.  
 
 
// Return the minimum number of stones that are to be removed to complete the given 
// task. 
 
// b=1 
// r=-1; 
 
// 1 1  
 
// For eg, input: BBRRBRBRBRBBR 
//             output: 1
import java.util.*;
public class longest_length_of_subarray
{
    static int helper(int arr[],HashMap<Integer,Integer> map)

    {
        int maxlen=0,prefix=0;
        for(int i=0;i<arr.length;i++)
        {
            prefix+=arr[i];
            if(map.containsKey(prefix))
            {
                int diff=i-map.get(prefix);
                maxlen=Math.max(maxlen,diff);
            }
            else
            map.put(prefix,i);
        }
        return (arr.length-maxlen);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        for(int testcase=0;testcase<N;testcase++)
        {
            String s=in.next();
            int arr[]=new int[s.length()];
            for (int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='B')// we consider B as 1 and R as -1 so if the sum is zero then the substring has same Bs and Rs consiqutevly 
                arr[i]=1;
                else
                arr[i]=-1;
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(0,-1);
            System.out.println("#"+testcase+": "+helper(arr,map));
        }
        
    }
}

