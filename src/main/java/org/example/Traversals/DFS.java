package org.example.Traversals;
import java.util.*;

public class DFS {

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> list = new ArrayList<>();

        int n = adj.size();
        boolean[] visited = new boolean[n];

        helper(0, visited, list, adj); // start node is 0

        return list;
    }

    private static void helper(int source, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adj){

        visited[source] = true;
        list.add(source);

        for(int neighbours : adj.get(source)){
            if(!visited[neighbours]){
                helper(neighbours, visited, list, adj);
            }
        }
    }
}
