package JavaCore.Datastructures.Path;


import java.util.*;


public class Unweighted {


    public List<Integer> findShortedPath( int v , int s , int d , int[][] edges ){

        if( v <= 0 || s < 0 || d < 0 || edges.length == 0 || edges == null ) return new ArrayList<>();

        // represent the graph in adjecency list
        List<List<Integer>> graph = buildGraph( v , edges );

        // track visited nodes and parents of each node visited from the source to the destination
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        boolean reachedDestination = false;

        // process all nodes using BFS algorithm. Initilize with the source node and stop when you reach destination
        Queue<Integer> processingQueue = new ArrayDeque<>();
        processingQueue.add( s );
        visited[s] = true;
        parent[s] = -1;
        while( !processingQueue.isEmpty() ){
            int currentNode = processingQueue.poll();
            List<Integer> connectedNodes = graph.get( currentNode );

            for( int node : connectedNodes){
                if( node != parent[currentNode] && visited[node] == false ){
                    visited[ node ] = true;
                    parent[ node ] = currentNode;
                    processingQueue.add( node );
                }
                if( node == d ) {
                    reachedDestination = true;
                }
            }

            if( reachedDestination == true ) break;
        }

        // backtrack the path from destination to source
        List<Integer> shortestPath = new ArrayList<>();
        if( reachedDestination == false && s != d ){
            return shortestPath;
        }

        shortestPath.add( d );
        int currentParent = parent[ d ];
        while( currentParent != -1){
            shortestPath.add( currentParent );
            currentParent = parent[ currentParent ];
        }

        Collections.reverse( shortestPath );
        return shortestPath;
    }

    private List<List<Integer>> buildGraph( int v , int[][] edges ){

        List<List<Integer>> graph = new ArrayList<>();

        for( int node = 0 ; node < v ; node++){
            graph.add(new LinkedList<>());
        }

        for( int[] edge : edges ){
            int node1 = edge[0];
            int node2 = edge[1];

            graph.get( node1 ).add( node2 );
            graph.get( node2 ).add( node1 );
        }

        return graph;
    }


}
