package JavaCore.datastructures;


import java.util.*;


/*
            OUTPUT
            ---------------------
            DAG Topological Order: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
            Cycle Graph Result: []
            Empty Graph Result: []
            Single Node Result: [0]
            Disconnected DAG Order: [0, 6, 1, 7, 2, 8, 3, 9, 4, 10, 5, 11]
 */

public class TestCode {

    public static void main(String[] args) {

        TopologicalSortKahns sorter = new TopologicalSortKahns();

        // Test 1: DAG with 12 nodes (e.g., task dependencies)
        // Nodes 0-11, edges representing prerequisites (acyclic)
        int V1 = 12;
        int[][] dagMatrix = new int[V1][V1];
        // Add edges: 0->1, 0->2, 1->3, 2->3, 3->4, 3->5, 4->6, 5->6, 6->7, 7->8, 8->9, 9->10, 10->11, 0->11 (direct)
        dagMatrix[0][1] = 1;
        dagMatrix[0][2] = 1;
        dagMatrix[1][3] = 1;
        dagMatrix[2][3] = 1;
        dagMatrix[3][4] = 1;
        dagMatrix[3][5] = 1;
        dagMatrix[4][6] = 1;
        dagMatrix[5][6] = 1;
        dagMatrix[6][7] = 1;
        dagMatrix[7][8] = 1;
        dagMatrix[8][9] = 1;
        dagMatrix[9][10] = 1;
        dagMatrix[10][11] = 1;
        dagMatrix[0][11] = 1; // Additional direct edge

        List<Integer> dagResult = sorter.topologicalSort(dagMatrix);
        System.out.println("DAG Topological Order: " + dagResult);
        // Expected: Some valid order like [0,1,2,3,4,5,6,7,8,9,10,11] or variations (e.g., 1 and 2 interchangeable)

        // Test 2: Graph with cycle (12 nodes, add cycle 3->1)
        int[][] cycleMatrix = new int[V1][V1];
        // Copy DAG edges
        System.arraycopy(dagMatrix, 0, cycleMatrix, 0, V1);
        // Add cycle: 3->1 (back edge)
        cycleMatrix[3][1] = 1;

        List<Integer> cycleResult = sorter.topologicalSort(cycleMatrix);
        System.out.println("Cycle Graph Result: " + cycleResult);
        // Expected: [] (empty list, since cycle detected)

        // Test 3: Empty graph
        int[][] emptyMatrix = new int[0][0];
        List<Integer> emptyResult = sorter.topologicalSort(emptyMatrix);
        System.out.println("Empty Graph Result: " + emptyResult);
        // Expected: []

        // Test 4: Single node, no edges
        int[][] singleMatrix = {{0}};
        List<Integer> singleResult = sorter.topologicalSort(singleMatrix);
        System.out.println("Single Node Result: " + singleResult);
        // Expected: [0]

        // Test 5: Disconnected DAG (12 nodes, two separate chains)
        int[][] disconnectedMatrix = new int[V1][V1];
        // Chain 1: 0->1->2->3->4->5
        disconnectedMatrix[0][1] = 1;
        disconnectedMatrix[1][2] = 1;
        disconnectedMatrix[2][3] = 1;
        disconnectedMatrix[3][4] = 1;
        disconnectedMatrix[4][5] = 1;
        // Chain 2: 6->7->8->9->10->11
        disconnectedMatrix[6][7] = 1;
        disconnectedMatrix[7][8] = 1;
        disconnectedMatrix[8][9] = 1;
        disconnectedMatrix[9][10] = 1;
        disconnectedMatrix[10][11] = 1;

        List<Integer> disconnectedResult = sorter.topologicalSort(disconnectedMatrix);
        System.out.println("Disconnected DAG Order: " + disconnectedResult);
        // Expected: Valid order like [0,6,1,7,2,8,3,9,4,10,5,11] or interleavings


    }


}
