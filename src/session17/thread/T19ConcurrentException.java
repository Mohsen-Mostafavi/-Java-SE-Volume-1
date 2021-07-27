package session17.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class T19ConcurrentException {

    public static void main(String[] args) {

         /*
           ArrayList Iterator
           fail-fast behavior: throw a ConcurrentModificationException
           rather than non-deterministic behavior in the face of concurrent modification during iteration
         */

        //ArrayList c = new ArrayList(); // fail-fast

         /*
           CopyOnWriteArrayList Iterator
           fail-safe (weakly consistent)
           iterator operate on a snapshot, so any subsequent changes are not visible via an iterator.
         */

       CopyOnWriteArrayList c = new CopyOnWriteArrayList(); // snapshot (fail-safe)


        c.add(1);
        c.add(2);
        c.add(3);

        new View(c).start();
        new Modify(c).start();

        try { Thread.sleep(1000); } catch(Exception e) {}

        System.out.println("--- original list ---");
        new View(c).start();


    }

    static class View extends Thread {

        List arr;

        View(List collection) {
            this.arr = collection;
        }

        public void run() {

            for (Iterator it = arr.iterator(); it.hasNext(); ) {
                System.out.println( it.next() );
                try { Thread.sleep(100); } catch(Exception e) {}
            }

        }

    }

    static class Modify extends Thread {

        List arr;

        Modify(List collection) {
            this.arr = collection;
        }

        public void run() {
            for (int i=4; i < 7; i++) {
                arr.add(i);
                try { Thread.sleep(100); } catch(Exception e) {}
            }
        }

    }


}


