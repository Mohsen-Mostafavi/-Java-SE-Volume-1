package session17.thread;

public class T15SleepInterrupt {
    
    public static void main(String[] args) {
        
        Thread sleepy = new Thread() {
            @Override
            public void run() {
                System.out.println("Sleepy: I am going to sleep for 10 seconds...");
                try { Thread.sleep(10*1000); } catch(InterruptedException e) {
                    System.out.println("Sleepy: Why did you interrupt me?!!!");
                }
            }
        };
        
        sleepy.start();
        
        try { Thread.sleep(3*1000); } catch(InterruptedException e) { }

        System.out.println("Going to interrupt the sleepy! :>");

        sleepy.interrupt();
        
    }
    
    
}
