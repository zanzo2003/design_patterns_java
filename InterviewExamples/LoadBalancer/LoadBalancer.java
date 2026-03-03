package InterviewExamples.LoadBalancer;

import InterviewExamples.LoadBalancer.strategy.LoadBalancingStrategy;

import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LoadBalancer {

    private List<Server> servers;
    private LoadBalancingStrategy strategy;

    public LoadBalancer( LoadBalancingStrategy strategy ){
        this.servers = Collections.synchronizedList(new LinkedList<>());
        this.strategy = strategy;
    }

    public void addServer( String ip , int load ){
        this.servers.add( new Server(ip, load));
    }

    public void removeServer( String ip ){
        this.servers = this.servers.stream()
                .filter( server -> !server.getIp().equals(ip))
                .collect( Collectors.toList());
        this.servers = Collections.synchronizedList( this.servers );
    }

    public void serveRequest( HttpRequest request ){
        Server server = strategy.getNextServer( this.servers );
        server.setCurrentLoad( server.getCurrentLoad() + 1);
        server.setCurrentLoad( server.getCurrentLoad() - 1);
    }
}
