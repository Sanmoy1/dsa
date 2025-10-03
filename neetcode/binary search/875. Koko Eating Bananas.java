
// brute force
// time complexity is O(n^2)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k;
        int l = piles.length;
        int max_k = 0;
        for (int i = 0; i < l; i++) {
            max_k = Math.max(piles[i], max_k);
        }
        k = max_k;
        for (int i = 1; i <= max_k; i++) {
            int sum = 0;
            for (int j = 0; j < l; j++) {

                sum += (piles[j] + i - 1) / i; // to calculate ceil functionality of integer version of division

                if (sum > h) {

                    break;
                }

            }
            if (sum <= h)
                k = Math.min(k, i);

        }
        return k;

    }
}

//optimal solution
//using binary search for the i loop
//time complexity is O(nlogn)

class Solution {
    public int helper(int i,int l, int piles[])
    {
        int sum = 0;
            for (int j = 0; j < l; j++) {

                sum += (piles[j] + i - 1) / i;

            }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = piles.length;
        int max_k = 0;
        for (int i = 0; i < l; i++) {
            max_k = Math.max(piles[i], max_k);
        }
        int left=1, right=max_k; 
           
        
        while(left<=right)
        {
            int mid = left + (right - left) / 2;

            if(helper(mid,l,piles)<=h)
            {
                
                right=mid-1;
            }
            else if(helper(mid,l,piles)>h)
            left=mid+1;
        }
        return left;

    }
}