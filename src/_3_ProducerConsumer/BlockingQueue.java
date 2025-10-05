package _3_ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.q = new LinkedList<>();
    }

    public boolean add(int element) {
        synchronized (q) {
            if (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            q.add(element);
            System.out.println("Added to the queue :" + element);
            q.notifyAll();
            return true;
        }
    }

    public int poll() {
        synchronized (q) {
            if (q.isEmpty()) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int element = q.poll();
            System.out.println("Polled from the queue :" + element);
            q.notifyAll();
            return element;
        }
    }

}
