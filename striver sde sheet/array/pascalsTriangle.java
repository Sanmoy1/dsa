//https://leetcode.com/problems/pascals-triangle/

// We will be using the combination formula which is n-1Cr-1. 
// Here n-1 = row number
// r-1 = column number

// So we use the first approach which is using the combination formula.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerArray = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                innerArray.add((int) ncr(i, j));
            }
            answer.add(innerArray);
        }
        return answer;
    }

    public static long ncr(int n, int r) {
        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}