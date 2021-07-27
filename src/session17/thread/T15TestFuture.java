package session17.thread;

import java.util.concurrent.*;

public class T15TestFuture {
    
     public static void main(String[] args) {
        
        System.out.println("Before Order...");

        Callable<Integer> pizza = new Callable<Integer>() {

            public Integer call() {

                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return sum;

            }
        };

        Future<Integer> f = order( pizza );

        System.out.println("After Order...");
        
        System.out.println("before get...");
        
        int k = 1;
        while ( !f.isDone() ) {
             System.out.println("Shopping...Item: " + k);
             k = k + 1;
             try {
                        Thread.sleep(500);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
             }
        }
        
        try {
            Integer value = f.get();
            System.out.println(value);
        } catch(Exception e) {
            e.printStackTrace();
        }    
        
        System.out.println("End of main...");
        
    }

    static Future<Integer> order( Callable<Integer> task ) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit( task );
    }
    
}
