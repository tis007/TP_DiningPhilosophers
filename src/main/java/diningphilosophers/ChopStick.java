package diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
    private static int stickCount = 0;
    private boolean iAmFree = true;
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    synchronized public boolean take() throws InterruptedException {
        if (!iAmFree) {
            wait(200);
            if (!iAmFree) {
                return false;
            }
        }
        iAmFree = false;
        System.out.println("baguette " + myNumber + " prise");
        return true;
    }


    synchronized public void release() {
            iAmFree = true;
            System.out.println("baguette " + myNumber + " relâchée");
    }

    @Override
    public String toString() {
        return "baguette #" + myNumber;
    }

}
