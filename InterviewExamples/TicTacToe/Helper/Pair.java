package InterviewExamples.TicTacToe.Helper;

public class Pair <T, K>{

    private T first;
    private K second;

    public Pair(T first, K second){
        this.first = first;
        this.second = second;
    }

    public void show(){
        System.out.println("{" + this.first + " " + this.second + "}");
    }

    public T getFirst(){
        return this.first;
    }

    public K getSecond(){
        return this.second;
    }
}
