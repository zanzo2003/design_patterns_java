package JavaCore.datastructures;

import java.util.List;

public class TestCode {

    public static void main(String[] args) {

        int[][] graph = {
                {0,1,0},
                {0,0,1},
                {0,0,0}
        };
        System.out.println( TopologicalSortDFS.topologicalSort(graph) );
    }
}
