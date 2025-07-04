import java.util.*;

public class NumberOfIslandsBFS {
    private void bfs(char[][] grid, int row, int col, int n, int m, boolean[][] vis){

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        vis[row][col] = true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();

            for(int[] dir : dirs){
                int nrow = pair[0] + dir[0];
                int ncol = pair[1] + dir[1];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == '1'){
                    queue.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
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