public class NumberOfIslands {
    int count=0;
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1') {
                    dfs(grid,i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid,int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>grid[0].length ){
            return;
        }
        else if(grid[i][j]=='1'){
            grid[i][j]='2';
            dfs(grid,i,j-1);
            dfs(grid,i-1,j);
            dfs(grid, i,j+1);
            dfs(grid,i+1,j);
        }

    }
}
