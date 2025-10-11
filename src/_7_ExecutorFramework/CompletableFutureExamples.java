package _7_ExecutorFramework;

import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExamples {

    private static final int THREADS = 5;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        for (int i = 0; i < THREADS ; i++) {
            int finalI = i;
            CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return finalI;
            }, executor).thenAccept(result -> {
                System.out.println("Result : " + result);
            });
        }
    }


}
