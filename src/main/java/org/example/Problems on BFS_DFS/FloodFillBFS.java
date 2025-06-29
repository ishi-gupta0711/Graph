import java.util.*;

public class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        int n = image.length;
        int m = image[0].length;
        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = image[i][j];
            }
        }

        bfs(sr, sc, color, original, n, m, image, answer);

        return answer;
    }

    private static void bfs(int sr, int sc, int color, int original, int n, int m, int[][] image, int[][] grid){

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        grid[sr][sc] = color;


        int[] rows = {0, 1, 0, -1};
        int[] cols = {1, 0, -1, 0};
        while(!queue.isEmpty()){

            int[] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];

            for(int i = 0; i < 4; i++){
                int nrow = row + rows[i];
                int ncol = col + cols[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initial && grid[nrow][ncol] != color){
                    queue.offer(new int[]{nrow, ncol});
                    grid[nrow][ncol] = color;
                }
            }
        }




        return answer;
    }
}