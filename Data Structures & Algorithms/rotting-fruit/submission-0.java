class Solution {
    public int orangesRotting(int[][] grid) {
        
        int freshCount = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0){
            return 0;
        }

        int[][] direc = {{1,0},{-1,0},{0,1},{0,-1}};
        int maxTime = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            int t = node[2];

            for(int[] i: direc){
                int nr = r + i[0];
                int nc = c + i[1];

                if(nr<0 || nc<0 || nr>=row || nc >=col) continue;
                if(grid[nr][nc] != 1) continue;

                grid[nr][nc] = 2;
                freshCount--; 
                maxTime = t+1;
                queue.add(new int[]{nc,nr,t+1});

            }
        }
        return freshCount==0?maxTime:-1;

    }
}
