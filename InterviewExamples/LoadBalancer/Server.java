package InterviewExamples.LoadBalancer;

public class Server {

    private String ip;
    private int currentLoad;

    public Server( String ip , int load ){
        this.currentLoad = load;
        this.ip = ip;
    }

    public String getIp(){
        return this.ip;
    }

    public int getCurrentLoad(){
        return this.currentLoad;
    }

    public void setCurrentLoad( int load ){
        this.currentLoad = load;
    }
}
