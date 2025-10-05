package _7_ExecutorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingRunnable {

    private static final int THREADS = 5;

    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        for (int i = 0 ; i < THREADS ; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Inside Thread execution : " + finalI);
            });
        }

        executor.shutdown();

    }
}
