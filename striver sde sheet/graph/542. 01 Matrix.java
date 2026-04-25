class Solution {
    class pair
    {
        int row, col, step;
        pair(int r,int c,int s)
        {
            row=r;
            col=c;
            step=s;
        
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int result[][]=new int [row][col];
        boolean visited[][]=new boolean[row][col];
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new pair(i,j,0));
                    result[i][j]=0;
                    visited[i][j]=true;
                    
                }
                

            }
        }
        int direction_row[]={0,-1,0,1};
        int direction_col[]={-1,0,1,0};
        while(!queue.isEmpty())
        {
            pair node=queue.poll();
            int row1=node.row;
            int col1=node.col;
            int step1=node.step;
            for(int i=0;i<4;i++)
            {
                int newrow=direction_row[i]+row1;
                int newcol=direction_col[i]+col1;
                if(newrow>=0 && newrow<row && newcol>=0 && newcol<col && visited[newrow][newcol]==false)
                {
                    queue.add(new pair(newrow,newcol,step1+1));
                    result[newrow][newcol]=step1+1;
                    visited[newrow][newcol]=true;

                }
            }
        }
        return result;
    }
}

// we are using bfs here and starting the bfs from the zeros instead of 1s because in the worst case scenario we have to perform bfs from every other node which increases time complexity exponentially