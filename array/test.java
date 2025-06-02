public class test{

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1}; // Example heights array
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        // Calculate leftMax values
        int max = heights[0];
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i]);
            leftMax[i] = max;
        }

        // Calculate rightMax values
        max = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            max = Math.max(max, heights[i]);
            rightMax[i] = max;
        }

        // Output the leftMax and rightMax values
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Index " + i + " - LeftMax: " + leftMax[i] + ", RightMax: " + rightMax[i]);
        }
        int check=0;
        for(int i=0;i<heights.length;i++)
        {
            check+=Math.min(leftMax[i],rightMax[i])-heights[i];
        }
        System.out.println(check);
    }
}

