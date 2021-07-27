package session17.retry;

import java.util.Random;
import java.util.concurrent.*;

public class Scheduled {

    public static void main(String[] args) {

        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();

        // .scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);

        /*ScheduledFuture f = */ s.scheduleAtFixedRate( new Runnable() {

            public void run() {
                int error = new Random().nextInt(4);
                System.out.println("Connection Error is : " + error);
                if (error == 0) {
                    System.out.println("Connection Created!");
                    s.shutdownNow();
                } else {
                    System.out.println("Connection Failed!");
                }
            }

        }, 1, 2, TimeUnit.SECONDS);

        System.out.println("The rest of code...");
        
    }

}
