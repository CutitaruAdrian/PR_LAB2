import java.util.concurrent.Semaphore;

import static java.lang.System.*;

public class Main {

    static Semaphore s1 = new Semaphore(0);
    static Semaphore s2 = new Semaphore(0);
    static Semaphore s3 = new Semaphore(0);
    static Semaphore s4 = new Semaphore(0);


    static Thread t1 = new Thread() {
        @Override
        public void run() {
            try {
                out.println("Thread 1");
                Thread.sleep(1000);
                s1.release(2);
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t2 = new Thread() {
        @Override
        public void run() {
            try {
                out.println("Thread 2");
                Thread.sleep(1000);
                s2.release(2);
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t3 = new Thread() {
        @Override
        public void run() {
            try {
                out.println("Thread 3");
                Thread.sleep(1000);
                s3.release();
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t4 = new Thread() {
        @Override
        public void run() {
            try {
                s1.acquire();
                s2.acquire();
                s3.acquire();
                out.println("Thread 4");
                Thread.sleep(1000);
                s4.release(3);
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t5 = new Thread() {
        @Override
        public void run() {
            try {
                s4.acquire();
                out.println("Thread 5");
                Thread.sleep(1000);
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };

    static Thread t6 = new Thread() {
        @Override
        public void run() {
            try {
                s4.acquire();
                out.println("Thread 6");
                Thread.sleep(1000);
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };

    static Thread t7 = new Thread() {
        @Override
        public void run() {
            try {
                s4.acquire();
                out.println("Thread 7");
                Thread.sleep(1000);
            } catch (InterruptedException v) {
                out.println(v);
            }
        }
    };

    public static void main(String a[]) {
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}