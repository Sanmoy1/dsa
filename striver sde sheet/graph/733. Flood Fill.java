import java.util.*;

class Solution {
    public class pair {
        int row, col;

        pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;

        Queue<pair> queue = new LinkedList<>();

        int iniColor = image[sr][sc];

        if (iniColor == color)
            return image;

        image[sr][sc] = color;

        queue.add(new pair(sr, sc)); // FIXED constructor call

        while (!queue.isEmpty()) {
            pair node = queue.poll();
            int row1 = node.row;
            int col1 = node.col;

            // LEFT
            if (col1 - 1 >= 0 && image[row1][col1 - 1] == iniColor) {
                image[row1][col1 - 1] = color;
                queue.add(new pair(row1, col1 - 1));
            }

            // RIGHT
            if (col1 + 1 < col && image[row1][col1 + 1] == iniColor) {
                image[row1][col1 + 1] = color;
                queue.add(new pair(row1, col1 + 1));
            }

            // UP
            if (row1 - 1 >= 0 && image[row1 - 1][col1] == iniColor) {
                image[row1 - 1][col1] = color;
                queue.add(new pair(row1 - 1, col1));
            }

            // DOWN
            if (row1 + 1 < row && image[row1 + 1][col1] == iniColor) {
                image[row1 + 1][col1] = color;
                queue.add(new pair(row1 + 1, col1));
            }
        }

        return image;
    }
}

//dfs version:

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];
        int[][] ans=image;
        int[] delRow={-1,0,1,0};// this is used to move in 4 directions and ignore 4 if condition
        int[] delCol={0,1,0,-1};//same for this
        dfs(sr,sc,image,ans,iniColor,color,delRow,delCol);
        return ans;
    }
    public void dfs(int row,int col,int[][] image,int[][] ans,int iniColor,int color,int[] delRow,int[] delCol){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){// 4 directions so 4 for loops
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && ans[nrow][ncol]!=color){
                dfs(nrow,ncol,image,ans,iniColor,color,delRow,delCol);
            }
        }
    }
}

