package multithreading.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ReusableCyclicBarrierExample {

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final int id;

        public Worker(CyclicBarrier barrier, int id) {
            this.barrier = barrier;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Phase 1
                System.out.println("Thread " + id + " is working on Phase 1");
                Thread.sleep(1000 + id * 200);
                System.out.println("Thread " + id + " reached barrier after Phase 1");
                barrier.await();

                // Phase 2
                System.out.println("Thread " + id + " is working on Phase 2");
                Thread.sleep(1000 + id * 300);
                System.out.println("Thread " + id + " reached barrier after Phase 2");
                barrier.await();

                System.out.println("Thread " + id + " completed all phases.");

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // CyclicBarrier for 3 threads, with a barrier action
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("===> All threads reached the barrier! Proceeding to next phase...\n");
        });

        // Start 3 threads
        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(barrier, i)).start();
        }
    }
}
