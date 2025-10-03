// https://leetcode.com/problems/container-with-most-water/

public class container_with_most_water {
   
   //complexity O(n)
   // here we are hoping that if the right height is greater than the left height then we will move the left pointer to the right to find a greater height and vice versa
   // we will keep track of the maximum area and return it

   public int maxArea(int[] height) {
        int n = height.length;
        int left = 0 , right = n - 1, ans = 0;
        while(left < right)
        {
            int minHeight = Math.min(height[left], height[right]);

            ans = Math.max(ans, (right - left) * minHeight);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }       
        return ans;
    }

    
}