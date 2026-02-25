package JavaCore.Datastructures.Path;




import java.util.*;


/*
 This class implements the Algorithm to efficiently find the shortest path between 2 Points in a
 Directed Acyclic Weighted Graph using a variation of the Standard Topological Sort Algorithm for
 BFS ( also known as Kahn's Algorithm )


 Steps for finding the shortest distance
  - Build the correct / convenient graph representation
  - Calculate the indegree of each node
  - Start with processing node with indegree 0
  - Follow Kahn's Algorithm
  - After getting Sort Order, now initilize record of final distance with source as 0 and all others as Max
  - Start iterating over the Sort Order and fill distances
 */

public class Weighted {

    class Pair{
        public int vertex;
        public int weight;
        public Pair(int v , int w ){
            this.vertex = v;
            this.weight = w;
        }
    }


    public int findShortestPath( int V , int source , int destination , int[][] edges ){

        int[] indegree = new int[V];
        Map<Integer, List<Pair>> graph = buildAdjacencyList( V , edges , indegree );

        Queue<Integer> nodesToBeProcessed = new ArrayDeque<>();
        for( int node = 0 ; node < V ; node++ ){
            if( indegree[node] == 0 ){
                nodesToBeProcessed.add( node );
            }
        }

        List<Integer> sortOrder = new ArrayList<>();
        while( !nodesToBeProcessed.isEmpty() ){
            int currentNode = nodesToBeProcessed.poll();
            sortOrder.add(currentNode);
            List<Pair> connectedNodes = graph.get(currentNode);
            for(Pair node : connectedNodes ){
                indegree[node.vertex]--;
                if(indegree[node.vertex] == 0){
                    nodesToBeProcessed.add(node.vertex);
                }
            }
        }

        // finding cost, setting the source nodes cost as 0.
        int[] finalCost = new int[V];
        Arrays.fill(finalCost, Integer.MAX_VALUE);
        finalCost[source] = 0;

        for( int node : sortOrder ){
            if( finalCost[node] != Integer.MAX_VALUE ){
                List<Pair> connectedNodes = graph.get(node);
                for( Pair connectedNode : connectedNodes){
                    finalCost[connectedNode.vertex] =
                            Math.min( finalCost[connectedNode.vertex] , finalCost[node] + connectedNode.weight);
                }
            }
        }

        return finalCost[destination];
    }



    private  Map<Integer, List<Pair>> buildAdjacencyList( int V , int[][] edges , int[] indegree ){

        Map<Integer, List<Pair>> representation = new HashMap<>();

        for( int i = 0 ; i < V ; i++ ){
            representation.put( i , new ArrayList<>() );
        }

        for( int[] edge : edges ){
            Pair edgeInformation = new Pair(edge[1], edge[2]);
            indegree[ edge[1] ]++;
            representation.get( edge[0] ).add( edgeInformation );
        }

        return representation;
    }
}
