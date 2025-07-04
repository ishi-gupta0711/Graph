import java.util.*;

public class MatrixBFS01{
    class Node{
        int row;
        int col;
        int distance;

        Node(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int[][] updateMatrix(int[][] mat){

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();
        int[][] result = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
                else{
                    vis[i][j] = false;
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0,-1}};
        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            result[node.row][node.col] = Math.min(min, node.distance);

            for(int[] dir : dirs){
                int nrow = dir[0] + node.row;
                int ncol = dir[1] + node.col;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]){
                    queue.offer(new Node(nrow, ncol, node.distance+1));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return result;
    }
}