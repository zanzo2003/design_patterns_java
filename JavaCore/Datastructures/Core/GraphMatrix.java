package JavaCore.Datastructures.Core;


/*
Adjecency list representation of Graph
 */

import java.util.*;

/**
 * A graph implementation using an adjacency matrix.
 */
public class GraphMatrix {

    private int[][] adjecencyMatrix;
    private int numOfVertices;

    /**
     * Constructs a new GraphMatrix with the specified number of vertices.
     *
     * @param numberOfVertices The initial number of vertices.
     */
    public GraphMatrix(int numberOfVertices){
        this.numOfVertices = numberOfVertices;
        this.adjecencyMatrix = new int[numOfVertices][numOfVertices];
    }

    /**
     * Adds an undirected edge between vertices i and j.
     *
     * @param i The index of the first vertex.
     * @param j The index of the second vertex.
     */
    public void addEdge(int i, int j){
        if (i >= 0 && i < numOfVertices && j >= 0 && j < numOfVertices) {
            this.adjecencyMatrix[i][j] = 1;
            this.adjecencyMatrix[j][i] = 1;
        }
    }

    /**
     * Removes the undirected edge between vertices i and j.
     *
     * @param i The index of the first vertex.
     * @param j The index of the second vertex.
     */
    public void removeEdge(int i, int j){
        if (i >= 0 && i < numOfVertices && j >= 0 && j < numOfVertices) {
            this.adjecencyMatrix[i][j] = 0;
            this.adjecencyMatrix[j][i] = 0;
        }
    }

    /**
     * Adds a new vertex to the graph, increasing the matrix size.
     */
    public void addVertex(){
        int[][] newAdjecencyMatrix = new int[numOfVertices+1][numOfVertices+1];

        for(int i = 0; i < numOfVertices; i++){
            for(int j = 0; j < numOfVertices; j++) newAdjecencyMatrix[i][j] = this.adjecencyMatrix[i][j];
        }

        this.adjecencyMatrix = newAdjecencyMatrix;
        this.numOfVertices += 1;
    }

    /**
     * Removes the specified vertex and all its incident edges.
     * The remaining vertices are re-indexed to fill the gap.
     *
     * @param v The index of the vertex to remove.
     */
    public void removeVertex(int v){
        if (v < 0 || v >= numOfVertices) return;

        int[][] newAdjecencyMatrix = new int[numOfVertices-1][numOfVertices-1];

        for(int i = 0; i < numOfVertices; i++){
            if(i == v) continue;
            for(int j = 0; j < numOfVertices; j++){
                if(j == v) continue;
                int newI = (i < v)? i: i-1;
                int newJ = (j < v)? j: j - 1;
                newAdjecencyMatrix[newI][newJ] = this.adjecencyMatrix[i][j];
            }
        }

        this.adjecencyMatrix = newAdjecencyMatrix;
        this.numOfVertices -= 1;
    }

    /**
     * Prints the adjacency matrix representation of the graph.
     */
    public void printGraph(){
        for(int i = 0; i < this.numOfVertices; i++){
            for(int j = 0; j < this.numOfVertices; j++){
                System.out.print(this.adjecencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Performs a depth-first search (DFS) traversal starting from vertex 0.
     *
     * @return A list containing the vertices visited in DFS order.
     */
    public List<Integer> dfs(){
        if (numOfVertices == 0) return new ArrayList<>();

        Stack<Integer> stk = new Stack<>();
        Set<Integer> visited = new LinkedHashSet<>();

        stk.push(0);

        while(!stk.isEmpty()){
            int node = stk.pop();
            
            if(!visited.contains(node)) {
                visited.add(node);
                // Push neighbors in reverse order to explore smaller indices first (optional)
                for(int i = this.numOfVertices - 1; i >= 0; i--){
                    if(this.adjecencyMatrix[node][i] == 1 && !visited.contains(i)){
                        stk.push(i);
                    }
                }
            }
        }

        return visited.stream().toList();
    }

    /**
     * Performs a breadth-first search (BFS) traversal starting from vertex 0.
     *
     * @return A list containing the vertices visited in BFS order.
     */
    public List<Integer> bfs(){
        if (numOfVertices == 0) return new ArrayList<>();

        Queue<Integer> que = new ArrayDeque<>();
        Set<Integer> visited = new LinkedHashSet<>();

        que.add(0);
        visited.add(0);

        while( !que.isEmpty() ){
            int currNode = que.poll();

            for(int i = 0; i < numOfVertices; i++){
                if(adjecencyMatrix[currNode][i] == 1 && !visited.contains(i)) {
                    visited.add(i);
                    que.add(i);
                }
            }
        }

        return visited.stream().toList();
    }
}
