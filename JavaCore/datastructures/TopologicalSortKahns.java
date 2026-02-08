package JavaCore.datastructures;


/*

 Steps to perform Topological sort using Kahn's Algorithm

 1. Find indegree of all nodes . (Indegree is the no of edges reaching the current node)

 2. Insert all the 0 - Indegree nodes in a Queue
 */



import java.util.*;

public class TopologicalSortKahns {



    public List<Integer> topologicalSort( int[][] matrix ){

        Map<Integer, List<Integer> > graph = buildList( matrix );
        int[] indegree = calculateIndegree( graph );
        Queue<Integer> nodes = new ArrayDeque<>();


        for( int i = 0; i < indegree.length ; i++){
            if( indegree[i] == 0) {
                nodes.add( i );
            }
        }

        List<Integer> result = new ArrayList<>();
        helper( graph, indegree, nodes, result );

        // Cycle detection
        if (result.size() != graph.size()) {
            return Collections.emptyList();
        }

        return result;

    }

    private void helper( Map<Integer, List<Integer>> graph, int[] indegree, Queue<Integer> nodes, List<Integer> result){

        while( !nodes.isEmpty() ){

            int currentNode = nodes.poll();
            graph.get( currentNode ).forEach( node -> {
                indegree[node]--;
                if( indegree[node] == 0) {
                    nodes.add(node);
                }
            });
            result.add( currentNode );
        }
    }

    private int[] calculateIndegree( Map<Integer, List<Integer>> graph){
        int[] result = new int[ graph.size() ];

        for( int i = 0 ; i < graph.size() ; i++){

            List<Integer> outwardEdges = graph.get( i );
            outwardEdges.forEach( edge -> result[edge]++);

        }

        return result;
    }

    private Map<Integer, List<Integer> > buildList( int[][] graph ){

        Map<Integer, List<Integer>> listRepresentation = new HashMap<>();
        for( int i = 0; i < graph.length; i++) listRepresentation.put( i, new LinkedList<>() );

        for( int i = 0; i < graph.length ; i++){
            for( int j = 0; j < graph.length; j++){
                if( graph[i][j] == 1) listRepresentation.get(i).add(j);
            }
        }

        return listRepresentation;
    }

}
