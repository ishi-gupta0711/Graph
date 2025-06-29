import java.util.*;

public class NumberOfProvincesBFS{

    public int findCircleNum(int[][] isConnected){

        int n = isConnected.length;
        int size = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                size++;
                bfs(i, visited, isConnected);
            }
        }
        return size;
    }

    private static void bfs(int source, boolean[] visited, int[][] mat){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int j = 0 ; j < mat.length; j++){
                if(!visited[j] && mat[source][j] == 1){
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}