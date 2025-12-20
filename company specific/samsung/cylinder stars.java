// question: https://leetcode.com/discuss/post/4167180/samsung-online-assessment-cylinder-stars-ty89/

import java.util.*;

class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // number of rows
        int M = sc.nextInt();   // number of columns
        sc.nextLine();          // consume newline

        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextLine();
        }

        System.out.println(solve(input, N, M));
    }

    public static int solve(String[] input, int N, int M) {

        // Step 1: store all positions of 'S' for each row
        List<List<Integer>> stars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stars.add(new ArrayList<>());
            for (int j = 0; j < M; j++) {
                if (input[i].charAt(j) == 'S') {
                    stars.get(i).add(j);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        // Step 2: try all possible target columns T (0 to M-1)
        for (int T = 0; T < M; T++) {
            int total = 0;

            // Step 3: compute minimal cost per row for target T
            for (int row = 0; row < N; row++) {
                int best = Integer.MAX_VALUE;

                for (int pos : stars.get(row)) {
                    int diff = Math.abs(pos - T);
                    int cost = Math.min(diff, M - diff); // circular distance
                    best = Math.min(best, cost);
                }

                total += best;
            }

            answer = Math.min(answer, total);
        }

        return answer;
    }
}
 
 //time complexity: O(N * M)
