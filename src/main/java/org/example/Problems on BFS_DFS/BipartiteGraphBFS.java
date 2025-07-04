import java.util.*;

public class BipartiteGraphBFS {

    public boolean bfs(int src, int[] res, ArrayList<ArrayList<Integer>> adj){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        res[src] = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int ne : adj.get(node)){

                if(res[ne] == -1){
                    res[ne] = 1 - res[node];
                    queue.offer(ne);
                }
                else if(res[ne] == res[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edges : graph){
            adj.get(edges[0]).add(edges[1]);
            adj.get(edges[1]).add(edges[0]);
        }
        int[] result = new int[adj.size()];

        Arrays.fill(result, -1);

        for(int i = 0; i < graph.length; i++){
            if(result[i] == -1){
                if(!bfs(i, result, adj)){
                    return false;
                }
            }
        }
        return true;
    }
}