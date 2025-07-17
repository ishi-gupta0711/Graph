import java.util.*;

public class ImplementUsingSet {

    public int[] dijkstra(int V, int[][] edges, int src){

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;  i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        set.add(new int[]{src,0});

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!set.isEmpty()){
            int[] pair = set.pollFirst();
            int u = pair[0];

            for(int[] ne : adj.get(u)){
                int v = ne[0];
                int wt = ne[1];

                if(dist[u] + wt < dist[v]){

                    if(dist[v] != Integer.MAX_VALUE){
                        set.remove(v, dist[v]);
                    }
                    dist[v] = dist[u] + wt;
                    set.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}