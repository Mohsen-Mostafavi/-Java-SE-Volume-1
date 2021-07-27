package session17.thread;

import java.util.Random;
import java.util.concurrent.*;

public class T18ArrayProcessMultiThread {
    
    final static int SIZE = 1_000_000; // Big Data Set (Generate Randomly)
    
    public static void main(String[] args) {
        
        System.out.println("Number of Cores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("===============================");
        new T18ArrayProcessMultiThread().createThread(1);
        System.out.println("===============================");
        new T18ArrayProcessMultiThread().createThread(8);
        System.out.println("===============================");
        new T18ArrayProcessMultiThread().createThread(12);
        System.out.println("===============================");
        new T18ArrayProcessMultiThread().createThread(32);
//        System.out.println("===============================");
//        new T18ArrayProcessMultiThread().createThread(64);
//        System.out.println("===============================");
//        new T18ArrayProcessMultiThread().createThread(128);
//        System.out.println("===============================");
//        new T18ArrayProcessMultiThread().createThread(256);
//        System.out.println("===============================");
        
    }
    
    void createThread(int numberOfThreads) {
        
        Random rand = new Random();
        double[] list = new double[SIZE];
        
        for (int i=0; i < SIZE; i++) 
            list[i] = rand.nextDouble() ; 

        long start = System.currentTimeMillis();
        
        ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);
       
        for (int i=0; i < numberOfThreads; i++) {
            int partiotionSize = SIZE / numberOfThreads;
            int from = i * partiotionSize;
            int to = from + partiotionSize;      
            System.out.println("Create new Thread from " + from + " to: " + to);
            pool.submit( new ChangeThread(list, from, to) );
        }
        
        pool.shutdown();
        
        try { // Assume 1 minute, for all threads to be done!
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }    
        
        long end = System.currentTimeMillis();
        System.out.println("Number of Data Elements: " + SIZE);
        System.out.println("Number of Threads: " + numberOfThreads);
        System.out.println("Time (s): " + (end-start)/1000.0);
        
    }
    
}

class ChangeThread implements Runnable {
    
    private double[] data;
    private int from;
    private int to;

    public ChangeThread(double[] data, int from, int to) {
        this.data = data;
        this.from = from;
        this.to = to;
    }

    public void run() { 
        
        // Any process on data
        for (int i=0; i < 10_000; i++) { 
                for (int j=from; j<to; j++) {
                    data[j]++;
                    data[j]--;
                }    
        }    
    
    }
    
}

/*
64 bit / win 8.1 / 8 core

Number of Cores: 8
===============================
Create new Thread from 0 to: 1000000
Number of Data Elements: 1000000
Number of Threads: 1
Time (s): 5.885
===============================
Create new Thread from 0 to: 125000
Create new Thread from 125000 to: 250000
Create new Thread from 250000 to: 375000
Create new Thread from 375000 to: 500000
Create new Thread from 500000 to: 625000
Create new Thread from 625000 to: 750000
Create new Thread from 750000 to: 875000
Create new Thread from 875000 to: 1000000
Number of Data Elements: 1000000
Number of Threads: 8
Time (s): 1.993
*/