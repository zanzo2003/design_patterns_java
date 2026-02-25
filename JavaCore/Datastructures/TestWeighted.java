package JavaCore.Datastructures;


import JavaCore.Datastructures.Path.Weighted;

class TestWeighted {

    public static void main(String[] args) {

        Weighted solver = new Weighted();

        System.out.println("=== Testing findShortestPath (DAG Weighted) ===\n");

        // Test 1: Simple linear DAG
        test(solver, 4, 0, 3,
                new int[][]{{0,1,2},{1,2,3},{2,3,4}},
                "Simple linear DAG",
                9);   // 2 + 3 + 4

        // Test 2: Multiple paths, choose minimum
        test(solver, 4, 0, 3,
                new int[][]{{0,1,1},{0,2,5},{1,3,2},{2,3,1}},
                "Multiple paths",
                3);   // 0->1->3 = 1 + 2

        // Test 3: Unreachable destination
        test(solver, 3, 0, 2,
                new int[][]{{0,1,4}},
                "Unreachable destination",
                Integer.MAX_VALUE);

        // Test 4: Source == Destination
        test(solver, 3, 1, 1,
                new int[][]{{0,1,5},{1,2,7}},
                "Source equals Destination",
                0);

        // Test 5: Disconnected graph
        test(solver, 5, 0, 4,
                new int[][]{{0,1,2},{1,2,3},{3,4,1}},
                "Disconnected graph",
                Integer.MAX_VALUE);

        // Test 6: Larger DAG
        test(solver, 6, 0, 5,
                new int[][]{
                        {0,1,2},
                        {0,2,4},
                        {1,3,7},
                        {2,4,1},
                        {4,3,2},
                        {3,5,1}
                },
                "Larger DAG",
                8);   // 0->2->4->3->5 = 4+1+2+1

        // Test 7: Single node
        test(solver, 1, 0, 0,
                new int[][]{},
                "Single node graph",
                0);

        // Test 8: No edges
        test(solver, 4, 0, 3,
                new int[][]{},
                "No edges",
                Integer.MAX_VALUE);
    }


    private static void test(Weighted solver,
                             int v,
                             int s,
                             int d,
                             int[][] edges,
                             String testName,
                             int expected) {

        int result = solver.findShortestPath(v, s, d, edges);

        System.out.println("Test: " + testName);
        System.out.println("Input  -> v=" + v + ", s=" + s + ", d=" + d);
        System.out.println("Result -> " + result);
        System.out.println("Expected -> " + expected);
        System.out.println("Status -> " + (result == expected ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------\n");
    }
}
