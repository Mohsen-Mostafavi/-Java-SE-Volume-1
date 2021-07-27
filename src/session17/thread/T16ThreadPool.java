package session17.thread;

import java.util.concurrent.*;

public class T16ThreadPool {

    public static void main(String[] args) {

        Executor p1 = Executors.newCachedThreadPool();

        ThreadPoolExecutor tp = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        Executor p2 = Executors.newSingleThreadExecutor();
        /*
        new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())
         */

        Executor p3 = Executors.newFixedThreadPool(3);
        /*
        new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
         */

        Executor p4 = Executors.newScheduledThreadPool(5);
        /*
        super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
         */

        Executor p5 = Executors.newWorkStealingPool();
        /*
        super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
         */

    }

}
