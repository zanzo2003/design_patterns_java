package JavaCore.datastructures;


/*
Adjecency list representation of Graph
 */


public class GraphMatrix {

    private int[][] adjecencyMatrix;
    private int numOfVertices;

    public GraphMatrix(int numberOfVertices){
        this.numOfVertices = numberOfVertices;
        this.adjecencyMatrix = new int[numOfVertices][numOfVertices];
    }

    public void addEdge(int i, int j){
        this.adjecencyMatrix[i][j] = 1;
        this.adjecencyMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j){
        this.adjecencyMatrix[i][j] = 0;
        this.adjecencyMatrix[j][i] = 0;
    }

    public void addVertex(){
        int[][] newAdjecencyMatrix = new int[numOfVertices+1][numOfVertices+1];

        for(int i = 0; i < numOfVertices; i++){
            for(int j = 0; j < numOfVertices; j++) newAdjecencyMatrix[i][j] = this.adjecencyMatrix[i][j];
        }

        this.adjecencyMatrix = newAdjecencyMatrix;
        this.numOfVertices += 1;
    }

    public void removeVertex(int v){
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

    public void printGraph(){
        for(int i = 0; i < this.numOfVertices; i++){
            for(int j = 0; j < this.numOfVertices; j++){
                System.out.print(this.adjecencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
