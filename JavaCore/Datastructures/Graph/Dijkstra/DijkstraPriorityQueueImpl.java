package JavaCore.Datastructures.Graph.Dijkstra;


import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;


/**
 * Provides an implementation of Dijkstra's shortest path algorithm using a priority queue.
 *
 * <p>This implementation calculates the minimum distance from a single source vertex to all other
 * vertices in a weighted graph with non-negative edge weights. The time complexity is
 * O( E log V), where V is the number of vertices and E is the number of edges.
 *
 * <p>The Dijsktra's algorithm can be used with a graph with negative weights because of the following 2 reasons
 *      1. The problem states to find the shortest path from source node to
 */

public class DijkstraPriorityQueueImpl {


    /**
     * Computes the shortest distances from the source node to all other nodes in the graph.
     *
     * @param V the number of vertices in the graph
     * @param adjacencyList the graph represented as an adjacency list, where {@code adjacencyList.get(i)}
     *     returns a list of edges from vertex {@code i}, each edge represented as a list
     *     containing {@code [neighborNode, weight]}
     * @param source the index of the starting vertex
     * @return a list where the index {@code i} contains the shortest distance from the source
     *     to vertex {@code i}
     */

    public List<Integer> impl( int V, List<List<List<Integer>>> adjacencyList, int source ){

        PriorityQueue<List<Integer>> nodesToBeProcessed = new PriorityQueue<>( (a , b) -> {
            int distanceA = a.get(0);
            int distanceB = b.get(0);
            int difference = distanceA - distanceB;
            if( difference == 0 ){
                return a.get(1) - b.get(1);
            }
            return difference;
        });

        nodesToBeProcessed.add( List.of(0 , source) );
        List<Integer> distance = new ArrayList<>(Collections.nCopies( V , Integer.MAX_VALUE ));
        distance.set( source , 0 );

        while( !nodesToBeProcessed.isEmpty() ){
            List<Integer> topData = nodesToBeProcessed.poll();
            int currentDistance = topData.get(0);
            int currentNode = topData.get(1);

            for( List<Integer> neighbour : adjacencyList.get( currentNode ) ){
                int node = neighbour.get(0);
                int weight = neighbour.get(1);
                int distanceFromCurrent = currentDistance + weight;

                if( distanceFromCurrent < distance.get(node) ){
                    distance.set( node , distanceFromCurrent );
                    nodesToBeProcessed.add( List.of(distanceFromCurrent , node) );
                }
            }

        }

        return distance;
    }
}

