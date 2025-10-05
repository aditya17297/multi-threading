package _2_Synchrinosed;


/**
 * 1. 2 threads can access push and pop parallelly.
 * 2. But 2 threads cannot access push/pop parallelly.
 */
public class StackDoubleLockSynchronisedBlock {

    int[] array;
    int top;
    Object lock;

    public StackDoubleLockSynchronisedBlock(int capacity) {
        array = new int[capacity];
        top = -1;
        lock = new Object();
    }

    public boolean push(int element) {
        synchronized (lock) {
            if (isFull()) {
                return false;
            }
            ++top;
            array[top] = element;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }

    public int pop() {
        synchronized (lock) {
            if (isEmpty()) return Integer.MIN_VALUE;

            int el = array[top];
            top--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return el;
        }
    }

    public boolean isFull() {
        return top == array.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

}
