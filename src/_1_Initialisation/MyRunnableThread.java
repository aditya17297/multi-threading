package _1_Initialisation;

public class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Inside MyRunnableThread : " + i);
        }
    }
}
