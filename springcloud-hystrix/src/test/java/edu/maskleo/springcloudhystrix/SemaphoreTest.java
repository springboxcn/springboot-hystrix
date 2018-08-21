package edu.maskleo.springcloudhystrix;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(20);

    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Thread working = new Thread(new Working(), "thread-" + i);
            working.start();
        }
    }

    static class Working implements Runnable {
        @Override
        public void run() {
            boolean timeout = true;
            Random r = new Random();
            try {
                System.out.println(Thread.currentThread().getName() + " begin working!");
                if (semaphore.tryAcquire(1, 1L, TimeUnit.SECONDS)) {
                    Thread.sleep(r.nextInt(100000));
                    timeout = false;
                    count.getAndIncrement();
                    System.out.println("成功了：" + count);
                }
            } catch (Exception e) {
            } finally {
                if (timeout) {
                    System.out.println(Thread.currentThread().getName() + " timeout working!");
                } else {
                    System.out.println(Thread.currentThread().getName() + " end working!");
                }
                semaphore.release();
            }
        }
    }

}
