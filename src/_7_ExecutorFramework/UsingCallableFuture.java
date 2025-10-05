package _7_ExecutorFramework;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UsingCallableFuture {

    private static final int THREADS = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> callableList = new ArrayList<>();
        for (int i = 0 ; i < THREADS ; i++) {
            int finalI = i;
            callableList.add(() -> {
                Thread.sleep(1000);
                return finalI;
            });
        }

        List<Future<Integer>> futureList = executor.invokeAll(callableList);

        for (Future<Integer> futureTask : futureList) {
            Integer result = futureTask.get();
            System.out.println("Result : " + result);
        }

        executor.shutdown();

    }

}
