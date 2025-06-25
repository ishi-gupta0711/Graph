package org.example.Traversals;
import java.util.*;
public class BFS {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> list = new ArrayList<>();

        int n = adj.size();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0); // start node is 0
        visited[0] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();
            list.add(node);

            for(int neighbours : adj.get(node)){
                if(!visited[neighbours]){
                    queue.offer(neighbours);
                    visited[neighbours] = true;
                }
            }
        }
        return list;
    }
}
