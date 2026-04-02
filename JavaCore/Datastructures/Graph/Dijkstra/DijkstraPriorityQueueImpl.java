package JavaCore.Datastructures.Graph.Dijkstra;


import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;


public class DijkstraPriorityQueueImpl {


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

