class Solution {
    //time complexity is O(2^(m+n))
    //space complexity is O(m+n)
    //TLE on leetcode
    //we use recursion here because we dont knwo know the exact no. of paths

    public int uniquePaths(int m, int n) {
        return helper(m, n, 0, 0);

    }

    public int helper(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i > m - 1 || j > n - 1)
            return 0;
        return helper(m, n, i + 1, j)+     helper(m, n, i, j + 1);
    }
}