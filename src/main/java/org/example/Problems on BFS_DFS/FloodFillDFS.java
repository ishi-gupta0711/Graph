import java.util.*;

public class FloodFillDFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color){

        int initialColor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;
        int[][] answer = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer[i][j] = image[i][j];
            }
        }

        dfs(sr, sc, image, answer, color, initialColor, n, m);
        return answer;
    }

    private static void dfs(int row, int col, int[][] image, int[][] grid, int color, int initial, int n, int m){

        grid[row][col] = color;

        int[] rows = {0, 1, 0, -1};
        int[] cols = {1, 0, -1, 0};

        for(int i = 0; i < 4; i++){
            int nrow = row + rows[i];
            int ncol = col + cols[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initial && grid[nrow][ncol] != color){
                dfs(nrow, ncol, image, grid, color, initial, n, m);
            }
        }
    }
}