package JavaCore.datastructures;


import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

public class GraphList {

    private Map<Integer, List<Integer>> adjecencyList;

    public GraphList(){
        this.adjecencyList = new HashMap<>();
    }

    public void addVertex(int vertex){
        this.adjecencyList.put(vertex, new LinkedList<>());
    }

    public void removeVertex(int vertex){
        this.adjecencyList.remove(vertex);
        for(List<Integer> neighbours: this.adjecencyList.values()){
            neighbours.remove(vertex);
        }
    }

    public void addEdge(int source, int destination){
        this.adjecencyList.get(source).add(destination);
        this.adjecencyList.get(destination).add(source);
    }

    public void removeEdge(int source, int destination){
        this.adjecencyList.get(source).remove(source);
        this.adjecencyList.get(destination).remove(source);
    }


}
