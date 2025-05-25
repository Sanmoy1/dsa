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

    //complexity O(m+n)
    // here we are using prefix sum (difference array)

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += diff[i];
            if (nums[i] > cnt) {
                return false;
            }
        }

        return true;
    }
    
}
