package InterviewExamples.LoadBalancer.strategy;

import InterviewExamples.LoadBalancer.Server;

import java.util.List;

public class LeastBalancerLoadBalancingStrategy implements LoadBalancingStrategy{


    @Override
    public Server getNextServer(List<Server> servers) {

        if( servers == null || servers.isEmpty() ){
            throw new RuntimeException(" No Servers present to server request ");
        }
        Server nextServer = servers.stream()
                .min( (a, b)-> a.getCurrentLoad() - b.getCurrentLoad())
                .get();
        return nextServer;
    }
}
