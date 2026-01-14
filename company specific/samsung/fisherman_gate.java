


import java.util.*;

public class FishingGateProblem {

    static int N = 10;
    static int[] gate = {4, 6, 10};
    static int[] fishermen = {5, 2, 2};

    static int[] fishSpot = new int[N + 1]; // 1-based indexing
    static boolean[] visited = new boolean[3];

    static int answer = Integer.MAX_VALUE;

    // Remove fishermen of a specific gate
    static void resetFishSpot(int gateIndex) {
        for (int i = 1; i <= N; i++) {
            if (fishSpot[i] == gateIndex + 1) {
                fishSpot[i] = 0;
            }
        }
    }

    // Assign fishermen of a gate with minimum distance
    static int calculateDistance(int index, int[] pos, int[] score) {
        int g = gate[index];
        int sum = 0;
        int left = g, right = g;

        // Assign all except last fisherman
        for (int i = 1; i < fishermen[index]; i++) {
            if (fishSpot[g] == 0) {
                fishSpot[g] = index + 1;
                sum += 1;
            } else {
                while (left > 0 && fishSpot[left] != 0) left--;
                while (right <= N && fishSpot[right] != 0) right++;

                int leftDist = left > 0 ? g - left + 1 : Integer.MAX_VALUE;
                int rightDist = right <= N ? right - g + 1 : Integer.MAX_VALUE;

                if (leftDist <= rightDist) {
                    fishSpot[left] = index + 1;
                    sum += leftDist;
                } else {
                    fishSpot[right] = index + 1;
                    sum += rightDist;
                }
            }
        }

        // Last fisherman (branching case)
        while (left > 0 && fishSpot[left] != 0) left--;
        while (right <= N && fishSpot[right] != 0) right++;

        int leftDist = left > 0 ? g - left + 1 : Integer.MAX_VALUE;
        int rightDist = right <= N ? right - g + 1 : Integer.MAX_VALUE;

        if (leftDist == rightDist) {
            pos[0] = left;
            pos[1] = right;
            score[0] = sum + leftDist;
            return 2; // two possible choices
        } else if (leftDist < rightDist) {
            fishSpot[left] = index + 1;
            score[0] = sum + leftDist;
        } else {
            fishSpot[right] = index + 1;
            score[0] = sum + rightDist;
        }
        return 1;
    }

    // Backtracking over gate order
    static void solve(int index, int currentSum, int count) {
        visited[index] = true;

        int[] pos = new int[2];
        int[] score = new int[1];
        int choices = calculateDistance(index, pos, score);

        currentSum += score[0];
        if (currentSum >= answer) return;

        if (count == 3) {
            answer = Math.min(answer, currentSum);
            return;
        }

        if (choices == 1) {
            for (int i = 0; i < 3; i++) {
                if (!visited[i]) {
                    solve(i, currentSum, count + 1);
                    visited[i] = false;
                    resetFishSpot(i);
                }
            }
        } else {
            // Try left
            fishSpot[pos[0]] = index + 1;
            for (int i = 0; i < 3; i++) {
                if (!visited[i]) {
                    solve(i, currentSum, count + 1);
                    visited[i] = false;
                    resetFishSpot(i);
                }
            }

            // Try right
            fishSpot[pos[0]] = 0;
            fishSpot[pos[1]] = index + 1;
            for (int i = 0; i < 3; i++) {
                if (!visited[i]) {
                    solve(i, currentSum, count + 1);
                    visited[i] = false;
                    resetFishSpot(i);
                }
            }
            fishSpot[pos[1]] = 0;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            solve(i, 0, 1);
            visited[i] = false;
            resetFishSpot(i);
        }
        System.out.println("Minimum total distance: " + answer);
    }
}
