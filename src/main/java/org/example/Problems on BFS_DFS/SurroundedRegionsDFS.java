import java.util.*;

public class SurroundedRegionsDFS {
    private static void dfs(int i, int j, char[][] board, int[][] dirs, boolean[][] vis, int n, int m){

        vis[i][j] = true;
        for(int[] dir : dirs){
            int nrow = dir[0] + i;
            int ncol = dir[1] + j;

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, board, dirs, vis, n, m);
            }
        }
    }
    public void solve(char[][] board){

        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(board[i][j] == 'O'){
                        dfs(i, j, board, dirs, vis, n, m);
                    }
                }
            }
        }
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j]){
                    board[i][j] = 'X';
                }
                else{
                    board[i][j] = 'O';
                }
            }
        }
    }
}