package _4_DeadlockImplementation;

public class DeadLocked {

    public static void main(String[] args) {
//        deadlock();
        deadlockSolution();
    }

    private static void deadlock() {
        Object r1 = new Object();
        Object r2 = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 tyring to lock resource 1");
            synchronized (r1) {
                try {
                    System.out.println("Thread 1 got lock on resource 1");
                    // do something
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 1 tyring to lock resource 2");
                synchronized (r2) {
                    try {
                        System.out.println("Thread 1 got lock on resource 2");
                        // do something
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 tyring to lock resource 2");
            synchronized (r2) {
                try {
                    System.out.println("Thread 2 got lock on resource 2");
                    // do something
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 2 tyring to lock resource 1");
                synchronized (r1) {
                    try {
                        System.out.println("Thread 2 got lock on resource 1");
                        // do something
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * Order in which lock is acquired should be same
     */
    private static void deadlockSolution() {
        Object r1 = new Object();
        Object r2 = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 tyring to lock resource 1");
            synchronized (r1) {
                try {
                    System.out.println("Thread 1 got lock on resource 1");
                    // do something
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 1 tyring to lock resource 2");
                synchronized (r2) {
                    try {
                        System.out.println("Thread 1 got lock on resource 2");
                        // do something
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 tyring to lock resource 2");
            synchronized (r1) {
                try {
                    System.out.println("Thread 2 got lock on resource 2");
                    // do something
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 2 tyring to lock resource 1");
                synchronized (r2) {
                    try {
                        System.out.println("Thread 2 got lock on resource 1");
                        // do something
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
