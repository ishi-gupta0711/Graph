import java.util.*;

public class NumberOfEnclavesBFS {
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        queue.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] pair = queue.poll();

            for(int[] dir : dirs){
                int nrow = dir[0] + pair[0];
                int ncol = dir[1] + pair[1];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    queue.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = true;
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