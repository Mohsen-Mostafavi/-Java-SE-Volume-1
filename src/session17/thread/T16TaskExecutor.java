package session17.thread;

import session16.thread.T04HumanRunnable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T16TaskExecutor {

    public static void main(String[] args) {

        Runnable task = new T04HumanRunnable("Ali");

        getExecutor().execute( task ); // No need to create Thread directly!

        /* Method submit(Runnable) extends base method execute(Runnable) by creating and returning a Future
         that can be used to cancel execution and/or wait for completion. */
        getExecutorService().submit( task );

        System.out.println("End of main thread");

    }

    static Executor getExecutor() {
        return new Executor() {
            @Override
            public void execute(Runnable task) {
                new Thread(task).start();
            }
        };
    }

    static ExecutorService getExecutorService() {
        return Executors.newSingleThreadExecutor();
    }

}
