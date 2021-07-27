package session17.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T17TestThreadPoolFixed {
    
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        executor.submit(new Runnable() { 
            public void run() { 
                for (int i=0; i<50; i++) {
                    System.out.println("111111");
                    try { Thread.sleep(100); } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }    
            }
        });

        executor.submit(new Runnable() { 
            public void run() { 
                for (int i=0; i<40; i++) {
                    System.out.println("22222");
                    try { Thread.sleep(100); } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }    
            }
        });

        executor.submit(new Runnable() { 
            public void run() { 
                for (int i=0; i<30; i++) {
                    System.out.println("333333");
                    try { Thread.sleep(100); } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executor.submit(new Runnable() {
            public void run() { 
                for (int i=0; i<20; i++) {
                    System.out.println("444444");
                    try { Thread.sleep(100); } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //System.out.println(executor);

        executor.shutdown(); // no more new task

    }

}
    

