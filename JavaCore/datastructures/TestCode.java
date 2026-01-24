package JavaCore.datastructures;

public class TestCode {

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        System.out.println("Initial Graph:");
        graph.printGraph();

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        System.out.println("\nAfter adding edges:");
        graph.printGraph();

        // Remove an edge
        graph.removeEdge(0, 2);

        System.out.println("\nAfter removing edge (0,2):");
        graph.printGraph();

        // Add a vertex
        graph.addVertex();

        System.out.println("\nAfter adding a vertex:");
        graph.printGraph();

        // Remove a vertex
        graph.removeVertex(1);

        System.out.println("\nAfter removing vertex 1:");
        graph.printGraph();
    }
}
