class Solution {
    // Time: O(log(n)), Space: O(1)
    // optimised approach
    // we find the reversed half of the number and compare it with the original number
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf /10;
    }
    // time complexity is O(n)
    // space complexity is O(1)
    // we find the no. of digits in the number and then reverse the number and compare
    public boolean isPalindrome(int x) {
        if(x<0)
        return false;
        int copy=x;
        int r,reverse=0,count=0;
        while(copy!=0)
        {
            copy=copy/10;
            count++;
        }
        copy=x;
        while(copy!=0)
        {
            r=copy%10;
            reverse=(int)(Math.pow(10,count-1)*r)+reverse;
            copy=copy/10;
            count--;
        }
        if(reverse==x)
        return true;
        else
        return false;
    }
}