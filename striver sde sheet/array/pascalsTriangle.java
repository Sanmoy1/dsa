//https://leetcode.com/problems/pascals-triangle/

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