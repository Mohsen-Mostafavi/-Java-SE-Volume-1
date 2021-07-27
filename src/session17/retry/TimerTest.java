package session17.retry;

import java.util.*;

public class TimerTest {

    public static void main(String[] args) {

        Timer timer = new Timer(); // since 1.3

        //    schedule(TimerTask task, long delay, long period)
        timer.schedule( new TimerTask() { // TimerTask is Runnbale

            public void run() {

                int error = new Random().nextInt(4);
                System.out.println("Connection Error is : " + error);
                if (error == 0) {
                    System.out.println("Connection Created!");
                    timer.cancel();
                } else {
                    System.out.println("Connection Failed!");
                }

            }
        } , 1000, 10);
        
        System.out.println("The rest of code...");

    }

}
