import java.util.*;

public class NumberOfEnclavesBFS {
    private static void dfs(int i, int j, int[][] grid, int[][] dirs, boolean[][] vis, int n, int m){

        vis[i][j] = true;
        for(int[] dir : dirs){
            int nrow = dir[0] + i;
            int ncol = dir[1] + j;

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, dirs, vis, n, m);
            }
        }
    }
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        dfs(i, j, grid, dirs, vis, n, m);
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}