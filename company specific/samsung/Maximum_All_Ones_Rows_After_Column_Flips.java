// question:
// The question involved a matrix of size n×mn×m filled with 0s and 1s. The task was to flip the values in the columns exactly kk times. This meant selecting a column (e.g., column 1) and toggling all 0s to 1s and vice versa. The goal was to determine the maximum number of rows that could be made entirely 1s.

//https://www.geeksforgeeks.org/interview-experiences/samsung-research-institute-bangalore-interview-experience-for-internship/

import java.util.*;

public class MaxAllOnesRows {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();// row
        int M = sc.nextInt();// column

        // Map to store frequency of each row pattern
        Map<Integer, Integer> freq = new HashMap<>();
        // Map to store number of zeros in each row pattern
        Map<Integer, Integer> zeroCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            int mask = 0;
            int zeros = 0;

            for (int j = 0; j < M; j++) {
                mask <<= 1;
                if (row.charAt(j) == '1') {
                    mask |= 1;
                } else {
                    zeros++;
                }
            }

            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            zeroCount.put(mask, zeros);
        }

        int K = sc.nextInt();
        int answer = 0;

        for (int mask : freq.keySet()) {
            int zeros = zeroCount.get(mask);

            // Feasibility check
            if (zeros <= K && (K - zeros) % 2 == 0) {
                answer = Math.max(answer, freq.get(mask));
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
