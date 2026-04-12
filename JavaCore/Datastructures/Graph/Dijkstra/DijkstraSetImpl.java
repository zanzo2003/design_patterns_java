package JavaCore.Datastructures.Graph.Dijkstra;

import java.util.*;


public class DijkstraSetImpl {

    public List<Integer> impl( int V , List<List<List<Integer>>> adjacencyList , int source ){

        List<Integer> distance = new ArrayList<>( Collections.nCopies( V , Integer.MAX_VALUE ) );
        TreeSet<int[]> nodesToProcess = new TreeSet<>( ( a , b ) -> {
            if( a[0] != b[0] ){
                return Integer.compare( a[0] , b[0] );
            }
            return Integer.compare( a[1] , b[1] );
        });

        nodesToProcess.add( new int[]{ 0 , source } );
        distance.set( source , 0 );

        while( !nodesToProcess.isEmpty() ){
            int[] currentData = nodesToProcess.pollFirst();
            int currentNode = currentData[1];
            int currentDistance = currentData[0];

            List<List<Integer>> nodes = adjacencyList.get( currentNode );
            for( List<Integer> data : nodes ) {

                int v = data.get(0);
                int weight = data.get(1);

                if (distance.get(v) > weight + currentDistance) {
                    if (distance.get(v) != Integer.MAX_VALUE) {
                        nodesToProcess.remove(new int[]{distance.get(v), v});
                    }
                    distance.set(v, currentDistance + weight);
                    nodesToProcess.add(new int[]{distance.get(v), v});
                }
            }
        }

        return distance;

    }
}
