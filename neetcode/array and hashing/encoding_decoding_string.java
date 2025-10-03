// We can use an encoding approach where we start with a number representing the length of the string, followed by a separator character (let's use # for simplicity), and then the string itself. To decode, we read the number until we reach a #, then use that number to read the specified number of characters as the string.

// https://www.geeksforgeeks.org/problems/encode-and-decode-strings/1

// The time and space complexity of this approach is O(n) for both encoding and decoding, where n is the total length of the input string.

// we can use string builder to reduce the space complexity

import java.util.ArrayList;

public class encoding_decoding_string {
    
    public String encode(String s[]) {
        // write your logic to encode the strings
        int len=0;
        String ans="";
        for (String i: s)
        {
            len=i.length();
            ans=ans+len+"#"+i;
        }
        return ans;
    }

    public String[] decode(String s) {
        // write your logic to decode the string
        ArrayList<String> arr=new ArrayList<>();
        String len="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if ((char)ch>=48 && (char)ch<=57)
            {
                len=len+ch;
            }
            else if(ch=='#')
            {
                arr.add(s.substring(i+1,i+1+Integer.parseInt(len)));
                i=i+Integer.parseInt(len);
                len="";
                
            }
        }
        return arr.toArray(new String[arr.size()]);
        
    }
    public static void main(String[] args) {
        encoding_decoding_string obj=new encoding_decoding_string();
        String s1[]={"a","b","c","d","e"};
        String s2=obj.encode(s1);
        String s3[]=obj.decode(s2);
        System.out.println(s3);
    }

}
