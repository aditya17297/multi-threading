package _6_HorseRaceSimulation;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Horse implements Runnable {

    private CountDownLatch finish;
    private CyclicBarrier start;
    private AtomicBoolean raceFinished;
    private int horseId;
    private int raceLength;
    private int currentLength;

    public Horse(CountDownLatch finish, CyclicBarrier start, AtomicBoolean raceFinished, int horseId) {
        this.finish = finish;
        this.start = start;
        this.raceFinished = raceFinished;
        this.horseId = horseId;
        this.raceLength = 100;
        this.currentLength = 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Horse : " + horseId + " ready to start");

        // Waits for all the threads to arive
        try {
            start.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Horse : " + horseId + " started the race");

        // Race
        while (!raceFinished.get() && raceLength > currentLength) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentLength = random.nextInt(10) + currentLength;
            System.out.println("Horse : " + horseId + " ran distance : " + currentLength);
        }


        // Top 3 horses countDown the latch
        if (!raceFinished.getAcquire()) {
            finish.countDown();
            System.out.println("Horse : " + horseId + " Finished race");
        } else {
            System.out.println("Horse : " + horseId + " Stopped at distance : " + currentLength);
        }

    }

}
