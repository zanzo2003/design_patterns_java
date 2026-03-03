package InterviewExamples.LoadBalancer.strategy;

import InterviewExamples.LoadBalancer.Server;

import java.util.List;

public interface LoadBalancingStrategy {
    Server getNextServer(List<Server> servers );
}
