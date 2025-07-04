import java.util.;

public class NumberOfDistinctIslandsDFS {

    public void bfs(int row , int col, ArrayList<String> list, int[][] grid, boolean[][] vis, int n, int m, int row0, int col0, int[][] dirs){

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col})
        vis[row][col] = true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            list.add((pair[0] - row0) + "," + (pair[1] - col0));
            for(int[] dir : dirs){
                int nrow = dir[0] + pair[0];
                int ncol = dir[1] + pair[1];

                if(nrow >=0 && nrow < n  && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    queue.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = true;
                }
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
                    bfs(i, j, list, grid, vis, n, m, i, j, dirs);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}