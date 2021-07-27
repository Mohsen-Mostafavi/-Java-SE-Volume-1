package session17.thread;

public class T14ThreadState {

    public static void main(String[] args) {

        Runnable r = () -> {
                System.out.println("[Start of Task]");

                Thread other = new Thread( () -> delay(200)  );
                other.start();
                while ( other.isAlive() ) ; // RUNNABLE

                delay(300); // TIMED_WAITING

                System.out.println("[End of Task]");
        };

        Thread t1 = new Thread(r);
        System.out.println( "1-" + t1.getState()  ); // NEW

        t1.start();

        delay(100);
        System.out.println( "2-" + t1.getState()  ); // RUNNABLE

        delay(300);
        System.out.println( "3-" + t1.getState()  ); // TIMED_WAITING

        delay(300);
        System.out.println( "4-" + t1.getState()  ); // TERMINATED

        System.out.println("End of main Thread!");

    }

    static void delay(int delayTime) {

        try {
            Thread.sleep(delayTime);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

}
