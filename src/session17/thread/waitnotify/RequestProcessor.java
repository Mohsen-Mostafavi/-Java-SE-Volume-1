package session17.thread.waitnotify;

import java.util.Queue;

public class RequestProcessor extends Thread {

       private Queue requestQueue;

       public RequestProcessor(Queue q) {
               requestQueue = q;
       }

       public void run() {

           synchronized(requestQueue) {

               System.out.println( Thread.currentThread().getName() + " sees " + requestQueue.size() + " requests");
               if (requestQueue.size() >= 1) {
                   System.out.println(Thread.currentThread().getName() + " starts processing the request..." );
                   requestQueue.poll(); // Retrieves and removes the head of this queue
                   return; // End of this thread
               }

               while ( requestQueue.size() < 1 ) {
                   try {
                       System.out.println( Thread.currentThread().getName() + " is waiting for request...");
                       requestQueue.wait(); // continue after notify()
                   } catch (InterruptedException e) { /* End of this thread */ }
               }

               System.out.println( Thread.currentThread().getName() + " sees " + requestQueue.size() + " requests and starts processing...");
               requestQueue.poll();
               // end of this thread

           }

       }

}  