package session17.retry;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestRetry {
    
    public static void main(String[] args) {

        Callable<Integer> task = new Callable<Integer>() {
            
            public Integer call() throws Exception {
                
                int error = new Random().nextInt(4);
                System.out.println("Connection Error is : " + error);
                if (error == 0)
                    System.out.println("Connection Created!");
                else {
                    System.out.println("Connection Failed!");
                    throw new Exception();
                }
                return error;
            }

        };

        RetriableTask<Integer> r = new RetriableTask<Integer>(task);
        try {
            int result = r.call();
            // use result
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
