package session17.thread.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class TestRequestGenerator {

    public static void main(String[] args) {

            Queue<Request> q = new LinkedList<>();
            q.offer( new Request("{JSON1}") );

            new RequestProcessor( q ).start();
            new RequestProcessor( q ).start();
            new RequestProcessor( q ).start();
        
            try {Thread.sleep(2*1000); } catch (InterruptedException e) {e.printStackTrace(); }
            System.out.println("Request Generator offers 2 more request to the queue ...");
            try {Thread.sleep(2*1000); } catch (InterruptedException e) {e.printStackTrace(); }

            q.offer( new Request("{JSON2}") );
            q.offer( new Request("{JSON3}") );

            System.out.println("Request Generator notifies consumers...");
            synchronized(q) { q.notifyAll(); }
        
    }

}