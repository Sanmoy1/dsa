// O(log(m*n)) time complexity
// O(1) space complexity
// treat the 2D array as a 1D array
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        int mid;
        while(left<=right)
        {
            mid=(left+right)/2;
            int row=mid/n;// divide by colmuns (n) as 2d -> row major order
            int col=mid%n;
            if(target<matrix[row][col])
            right=mid-1;
            else if(target>matrix[row][col])
            left=mid+1;
            else
            return true;
        }
        return false;
        
    }
}