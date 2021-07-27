package session17.thread;

import java.util.*;

public class T18ArraySortParallel {

    final static int SIZE = 100_000_000; // Data Size (Generate Randomly)
    
    public static void main(String[] args) {
        
        System.out.println("Number of Cores: " + Runtime.getRuntime().availableProcessors());
        
        double[] arr = new double[SIZE];
        
        Random rand = new Random();

        for (int i=0; i < SIZE; i++) 
            arr[i] = rand.nextDouble() ;
        
        double[] myArray = Arrays.copyOf(arr, SIZE);
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(myArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Time take in parallel: " + (endTime - startTime)/1000.0 );
        
        myArray = null; // free up some heap
        System.gc();

        double[] myArray2 = Arrays.copyOf(arr, SIZE);
        startTime = System.currentTimeMillis();
        Arrays.sort(myArray2);
        endTime = System.currentTimeMillis();
        System.out.println("Time take in serial: " + (endTime - startTime)/1000.0 );

    }
    
}


/*
64 bit / 8 Core / Win 8.1
Number of Cores: 8
Time take in parallel: 2.899
Time take in serial: 11.72
*/