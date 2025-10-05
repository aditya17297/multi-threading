package _5_VolatileKeyword;

import java.util.concurrent.locks.Lock;

public class Main {

    public static void main(String[] args) {
        for (int i = 0 ; i < 5 ; i++) {
            int finalI = i;
            Thread thread  = new Thread(() -> {
                SingletonClass singleton = SingletonClass.getInstance();
                System.out.println("Singleton Object : " + singleton + " from thread : " + finalI);
            }) ;
            thread.start();
        }
    }

}
