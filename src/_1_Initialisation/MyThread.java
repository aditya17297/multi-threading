package _1_Initialisation;

public class MyThread extends Thread {

    public MyThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Inside " + Thread.currentThread().getName() + " : " + i);
        }
    }

}
