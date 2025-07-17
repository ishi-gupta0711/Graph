import java.util.*;

public class ImplementUsingPriorityQueue {

    public static class Pair{
        int node;
        int distance;

        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        pq.offer(new Pair(src, 0));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int u = pair.node;
            int w = pair.distance;

            for(Pair p : adj.get(u)){
                int v = p.node;
                int wt = p.distance;

                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
