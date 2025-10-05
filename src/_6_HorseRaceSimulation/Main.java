package _6_HorseRaceSimulation;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {

        CountDownLatch finish = new CountDownLatch(3);
        CyclicBarrier start = new CyclicBarrier(10);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        for (int i = 0; i < 10 ; i++) {
            Thread th = new Thread(new Horse(finish, start, atomicBoolean, i));
            th.start();
        }

        try {
            finish.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        atomicBoolean.compareAndExchange(false, true);
        System.out.println("Race Stopped");
    }
}
