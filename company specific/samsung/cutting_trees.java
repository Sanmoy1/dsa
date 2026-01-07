import java.util.*;
// question : https://leetcode.com/discuss/post/6762372/samsung-dsa-question-by-shubhamsahu12254-wwks/
public class cutting_trees {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // Road length
        N++; // Include end position
        int[] L = new int[N];
        int[] R = new int[N];

        int totalTrees = 0;
        int maxHeight = 0;

        // Read left trees
        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
            if (L[i] > 0) {
                maxHeight = Math.max(maxHeight, L[i]);
                totalTrees++;
            }
        }

        // Read right trees
        for (int i = 0; i < N; i++) {
            R[i] = sc.nextInt();
            if (R[i] > 0) {
                maxHeight = Math.max(maxHeight, R[i]);
                totalTrees++;
            }
        }

        // Store first and last positions for each tree height
        int[] firstPos = new int[maxHeight + 1];
        int[] lastPos = new int[maxHeight + 1];
        Arrays.fill(firstPos, -1);
        Arrays.fill(lastPos, -1);
        System.out.println("maxHeight= " + (maxHeight + 1));

        for (int i = 0; i < N; i++) {
            if (L[i] > 0) {
                if (firstPos[L[i]] == -1) firstPos[L[i]] = i;
                lastPos[L[i]] = i;
            }
            if (R[i] > 0) {
                if (firstPos[R[i]] == -1) firstPos[R[i]] = i;
                lastPos[R[i]] = i;
            }
        }
        System.out.println("firstPos: " + Arrays.toString(firstPos));
        System.out.println("lastPos: " + Arrays.toString(lastPos));
        


        // DP arrays: time if start from first or last position of height i
        int[] dpFirst = new int[maxHeight + 1];
        int[] dpLast = new int[maxHeight + 1];

        // Start from the tallest tree
        int fPos = firstPos[maxHeight];
        int lPos = lastPos[maxHeight];
        
        // To end at firstPos, must visit lastPos first: 0 -> lastPos -> firstPos
        dpFirst[maxHeight] = Math.abs(lPos) + Math.abs(lPos - fPos);
        // To end at lastPos, must visit firstPos first: 0 -> firstPos -> lastPos
        dpLast[maxHeight] = Math.abs(fPos) + Math.abs(fPos - lPos);

        int prevHeight = maxHeight;

        for (int h = maxHeight - 1; h >= 1; h--) {
            if (firstPos[h] == -1) {
                dpFirst[h] = dpFirst[h + 1];
                dpLast[h] = dpLast[h + 1];
                System.out.println("Index= " +h);
                
                System.out.println();
                continue;
                
            }

            int start = firstPos[h];
            int end = lastPos[h];

            int prevFirst = firstPos[prevHeight];
            int prevLast = lastPos[prevHeight];

            int ansFirst = Math.min(
                dpFirst[prevHeight] + Math.abs(prevFirst - end) + Math.abs(end - start),
                dpLast[prevHeight] + Math.abs(prevLast - end) + Math.abs(end - start)
            ); // this is to get the min distance from prevFirst -> end-> start and PrevLast -> end -> start

            int ansLast = Math.min(
                dpFirst[prevHeight] + Math.abs(prevFirst - start) + Math.abs(start - end),
                dpLast[prevHeight] + Math.abs(prevLast - start) + Math.abs(start - end)
            );

            dpFirst[h] = ansFirst;
            dpLast[h] = ansLast;

            prevHeight = h;
        }
        System.out.println("dpFirst: " + Arrays.toString(dpFirst));
        System.out.println("dpLast: " + Arrays.toString(dpLast));

        int finalPosFirst = firstPos[prevHeight];
        int finalPosLast = lastPos[prevHeight];
        System.out.println("finalPosfirst: "+finalPosFirst);

        // Add travel to the end of the road (N-1)
        int result = Math.min(
            dpFirst[prevHeight] + Math.abs(finalPosFirst - (N - 1)),
            dpLast[prevHeight] + Math.abs(finalPosLast - (N - 1))
        ) + totalTrees;

        System.out.println(result);
    }
}
