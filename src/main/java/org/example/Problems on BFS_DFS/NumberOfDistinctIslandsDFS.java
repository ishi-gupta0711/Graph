import java.util.;

public class NumberOfDistinctIslandsDFS {

    public void dfs(int row , int col, ArrayList<String> list, int[][] grid, boolean[][] vis, int n, int m, int row0, int col0, int[][] dirs){

        vis[row][col] = true;
        list.add((row - row0) + "," + (col - col0));
        for(int[] dir : dirs){
            int nrow = dir[0] + row;
            int ncol = dir[1] + col;

            if(nrow >=0 && nrow < n  && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, list, grid, vis, n, m, row, col, dirs);
            }
        }


    }
    int countDistinctIslands(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        HashSet<ArrayList<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, list, grid, vis, n, m, i, j, dirs);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}