package JavaCore.MultiThreading;

public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread running for the instacne " + this.getClass() );
    }
}
