package JavaCore.Datastructures;

import JavaCore.Datastructures.Path.Unweighted;

import java.util.*;

class Test {

    public static void main(String[] args) {
        Unweighted solver = new Unweighted();

        System.out.println("=== Testing findShortedPath ===\n");

        // Test 1: Normal path
        test(solver, 4, 0, 3, new int[][]{{0,1},{1,2},{2,3}},
                "Normal path", List.of(0,1,2,3));

        // Test 2: Source == Destination
        test(solver, 1, 0, 0, new int[][]{},
                "Source == Destination", List.of(0));

        // Test 3: No path exists
        test(solver, 3, 0, 2, new int[][]{{0,1}},
                "No path exists", List.of());

        // Test 4: Disconnected graph
        test(solver, 5, 0, 4, new int[][]{{0,1},{1,2},{3,4}},
                "Disconnected graph", List.of());

        // Test 5: Multiple shortest paths (any one is fine)
        test(solver, 5, 0, 4, new int[][]{{0,1},{1,2},{2,4},{0,3},{3,4}},
                "Multiple shortest paths", List.of(0,3,4));   // or [0,1,2,4] both length 3

        // Test 6: Graph with cycle
        test(solver, 4, 0, 3, new int[][]{{0,1},{1,2},{2,0},{0,3}},
                "Graph with cycle", List.of(0,3));

        // Test 7: Single node, no edges
        test(solver, 1, 0, 0, new int[][]{},
                "Single node, no edges", List.of(0));

        // Test 8: Empty graph (v=0)
        test(solver, 0, 0, 0, new int[][]{},
                "v=0 edge case", List.of());
    }

    private static void test(Unweighted solver, int v, int s, int d,
                             int[][] edges, String testName, List<Integer> expected) {

        List<Integer> result = solver.findShortedPath(v, s, d, edges);

        System.out.println("Test: " + testName);
        System.out.println("Input  -> v=" + v + ", s=" + s + ", d=" + d);
        System.out.println("Result -> " + result);
        System.out.println("Expected -> " + expected);
        System.out.println("Status -> " + (result.equals(expected) ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------\n");
    }
}