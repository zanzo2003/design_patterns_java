package JavaCore.datastructures;

import java.util.List;

public class TestCode {

    public static void main(String[] args) {

        GraphMatrix graph = new GraphMatrix(5);

        System.out.println("Initial Graph:");
        graph.printGraph();

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        System.out.println("Final Graph:");
        graph.printGraph();


        System.out.println("--------DFS---------");
        List<Integer> dfs = graph.dfs();
        for(int i: dfs){
            System.out.println(i);
        }

        System.out.println("--------DFS---------");
        List<Integer> bfs = graph.bfs();
        for(int i: bfs){
            System.out.println(i);
        }
    }
}
