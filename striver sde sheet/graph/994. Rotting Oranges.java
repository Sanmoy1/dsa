class Solution {
    public class pair {
        int row, col, time;

        pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<pair> queue=new LinkedList<>();
        int totalTime=0;
        int rowsL=grid.length;        
        int colsL=grid[0].length;
        boolean [][] visited=new boolean[rowsL][colsL];
        
        for(int i=0;i<rowsL;i++)
        {
            for(int j=0;j<colsL;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new pair(i,j,0));
                    visited[i][j]=true;
                }
                else if(grid[i][j]==1)
                fresh++;
            }
        }
       
        while(!queue.isEmpty())
        {
            pair node=queue.poll();
            int row=node.row;
            int col=node.col;
            int time=node.time;
            totalTime=Math.max(totalTime,time);
            
                if(col+1<colsL && grid[row][col+1]==1 && visited[row][col+1]!=true)
                {
                    visited[row][col+1]=true;
                    queue.add(new pair(row,col+1,time+1));
                    fresh--;
                }
                 if(row+1<rowsL && grid[row+1][col]==1 && visited[row+1][col]!=true)
                {
                    visited[row+1][col]=true;
                    queue.add(new pair(row+1,col,time+1));
                    fresh--;
                }
                 if(col-1>=0 && grid[row][col-1]==1 && visited[row][col-1]!=true)
                {
                    visited[row][col-1]=true;
                    queue.add(new pair(row,col-1,time+1));
                    fresh--;
                }
                 if(row-1>=0 && grid[row-1][col]==1 && visited[row-1][col]!=true)
                {
                    visited[row-1][col]=true;
                    queue.add(new pair(row-1,col,time+1));
                    fresh--;
                }      
        
        }
        if(fresh>0)
        return -1;
        else
        return totalTime;


    }
}