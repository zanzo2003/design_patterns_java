package JavaCore.MultiThreading;

public class Test {

    public static void main( String[] args ){
        ThreadRunnable runnable = new ThreadRunnable();
        Thread thread1 = new Thread( runnable );
        Thread thread2 = new Thread( runnable );
        Thread thread3 = new Thread( runnable );
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println( "New thread ID's: " + thread1.getName()
                + " " + thread2.getName()
                + " " + thread3.getName() );
    }

}