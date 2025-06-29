import java.util.*;

public class TopologicalSort{

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> result = new ArrayList<>();

        int n = adj.size();
        int[] indegree = new int[n];

        for(ArrayList<Integer> list : adj){
            for(int num : list){
                indegree[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }
}
