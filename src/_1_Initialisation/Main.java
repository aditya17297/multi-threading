package _1_Initialisation;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main Thread Started");
        Thread myThread = new MyThread("MyThread");
        myThread.start();

        Thread myRunnableThread = new Thread(new MyRunnableThread());
        myRunnableThread.start();
        System.out.println("Main Thread Ended");
    }

}
