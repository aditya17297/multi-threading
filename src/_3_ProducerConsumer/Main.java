package _3_ProducerConsumer;

public class Main {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(10);

        Thread producer = new Thread(() -> {
            for (int i = 0 ; i < 20 ; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                blockingQueue.add(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0 ; i < 20 ; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int element = blockingQueue.poll();
            }
        });

        producer.start();
        consumer.start();
    }
}
