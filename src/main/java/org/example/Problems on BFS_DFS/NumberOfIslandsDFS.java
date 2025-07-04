import java.util.*;

public class NumberOfIslandsDFS {
    private void dfs(char[][] grid, int i, int j, int n, int m, boolean[][] vis){

        vis[i][j] = true;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for(int[] dir : dirs){
            int nrow = i + dir[0];
            int ncol = j + dir[1];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == '1'){
                dfs(grid, nrow, ncol, n, m, vis);
            }
        }
    }
    public int numIslands(char[][] grid) {

        int count = 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(grid, i, j, n, m, vis);
                }
            }
        }
        return count;
    }
}