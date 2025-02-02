//https://leetcode.com/problems/valid-anagram/

// Converting the string to array
// Sorting the array and checking the arrays are equal or not using Arrays.equals() method
// Time complexity is O(mlogm+nlogm) and space complexity is O(n)

import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        char array1[]= s.toCharArray();
    char array2[]= t.toCharArray();
    if(array1.length!=array2.length)
    return false;

    Arrays.sort(array1);
    Arrays.sort(array2);
    return Arrays.equals(array1,array2);
    }
}

// This is the optimized solution using ascii values
// Time complexity is O(n+m)

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }

        int c[]=new int [26];//there are a total of 26 characters
        for(int i=0;i<s.length();i++)
        {
            c[s.charAt(i)-'a']++;// store the frequency of each character
            c[t.charAt(i)-'a']--;
        }

        for(int i:c)
        {
            if(i!=0)
            return false;
        }
        return true;
    }
}
