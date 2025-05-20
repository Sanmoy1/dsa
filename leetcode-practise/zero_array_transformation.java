//https://leetcode.com/problems/zero-array-transformation-i/description/?envType=daily-question&envId=2025-05-20

//3355. Zero Array Transformation I


public class zero_array_transformation {
    //time limit exceeded
    //complexity O(n^2)

    public boolean isZeroArray(int[] nums, int[][] queries) {
        for (int[] i : queries) {

            int l = i[0];
            int r = i[1];

            for (int j = 0; j < nums.length; j++) {
                if (j >= l && j <= r && nums[j] != 0) {

                    nums[j] = nums[j] - 1;
                }
            }

        }

        for (int i : nums) {
            if (i != 0)
                return false;
        }
        return true;

    }
    
}
