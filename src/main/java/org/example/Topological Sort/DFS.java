import java.util.*;

public class TopologicalSort{

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> result = new ArrayList<>();

        int n = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(adj, visited, i, stack);
            }
        }
        while(!stack.isEmpty()){
            int num = stack.pop();
            result.add(num);
        }
        return result;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source, Stack<Integer> stack){

        visited[source] = true;

        for(int neighbours : adj.get(source)){
            if(!visited[neighbours]){
                dfs(adj, visited, neighbours, stack);
            }
        }
        stack.push(source);
    }
}
