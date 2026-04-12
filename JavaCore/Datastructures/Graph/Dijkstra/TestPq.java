package JavaCore.Datastructures.Graph.Dijkstra;

import java.util.*;

public class TestPq {

    public static void main(String[] args) {

        int V = 5; // number of vertices

        // Initialize adjacency list
        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: (u -> v, weight)
        adj.get(0).add(List.of(1, 2));
        adj.get(0).add(List.of(2, 4));

        adj.get(1).add(List.of(2, 1));
        adj.get(1).add(List.of(3, 7));

        adj.get(2).add(List.of(4, 3));

        adj.get(3).add(List.of(4, 1));


        /*
        Graph Visualization

0 --2--> 1 --1--> 2 --3--> 4
 \       |
  4      7
   \     |
     --> 3 --1--> 4

         */

        // Source node
        int source = 0;

        // Call Dijkstra
        DijkstraPriorityQueueImpl dijkstra = new DijkstraPriorityQueueImpl();
        List<Integer> result = dijkstra.impl(V, adj, source);

        // Print result
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Node " + i + " -> " + result.get(i));
        }
    }
}