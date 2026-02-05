package JavaCore.datastructures;


/*
    DAG - Directed Acyclic Graph - This algorithm is only application to DAG's

    What does the algorithm do ?
    - It is a Linear ordering of vertices such that for every edge U -> V, U will
    always appear before V.
    Egs :- directions 0 -> 1, 0 -> 2, 1 -> 3 and 2 -> 3
                    0
                  /   \
                 1     2
                  \   /
                    3
        The topological sort for this will be
        0 1 2 3 -> If we look at the adjecency list of the above graph
            0 -> 1, 2
            1 -> 3
            2 -> 3
            3 ->
         Consider the order {0, 1, 2, 3}, here in the list we can see that 1, 2 always appears after 0 in the
         representation, similarly, 3 always appears after both 1 and 2. This shows that the order of the direction
         is maintained.

       Why does this algorithm only work of Directed Acyclic Graphs ?
            - The reason is very simple. If the graph is undirected, then for edge UV from node U to V can also mean
            be from V to U making it bidirectional meaning there is no fixed order. If the graph is cyclic, then there
            will be a conflict in the of representation. Example: Say we have 0 -> 1, 1 -> 2, 2 -> 1. Here the order say that
            0, 1, 2, should work, but when you look carefully, 0 should come after 2 as the directions 2 -> 0.
 */


import java.util.*;


// this is the DFS Implementation of the algorithm
public class TopologicalSortDFS {


    public static List<Integer> topologicalSort(int[][] directedGraph){

        int v = directedGraph.length;

        // creating adjecency list representation for the directed graph
        Map<Integer, List<Integer>> adjencencyList = new HashMap<>();
        for(int i = 0; i < v; i++){
            adjencencyList.put(i, new LinkedList<>());
        }

        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                if(directedGraph[i][j] == 1) adjencencyList.get(i).add(j);
            }
        }

        List<Integer> result = new ArrayList<>();

        boolean[] isVisited = new boolean[v];
        Stack<Integer> order = new Stack<>();

        for(int i = 0; i < v; i++){

            // dfs for not visited nodes
            if( isVisited[i] == false ){
                dfs(adjencencyList, i, isVisited, order);
            }
        }

        while( !order.isEmpty() ) result.add( order.pop() );

        return result;
    }

    private static void dfs( Map<Integer, List<Integer>> graph, int currentNode, boolean[] isVisited, Stack<Integer> stk ){


        isVisited[ currentNode ] = true;

        List<Integer> edgesFormCurrent = graph.get( currentNode );

        edgesFormCurrent.forEach( node -> {
            if( isVisited[ node ] == false ) dfs(graph, node, isVisited, stk);
        });

        stk.push( currentNode );

        return ;

    }
}
