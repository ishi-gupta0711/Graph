import java.util.*;

public class NumberOfProvincesDFS{

    public int findCircleNum(int[][] isConnected){

        int n = isConnected.length;
        int size = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                size++;
                dfs(i, visited, isConnected);
            }
        }
        return size;
    }

    private int dfs(int source, boolean[] visited, int[][] mat){

        visited[source] = true;

        for(int j = 0; j < mat.length; j++){
            if(!visited[j] && mat[source][j] == 1){
                dfs(j, visited, mat);
            }
        }
    }
}