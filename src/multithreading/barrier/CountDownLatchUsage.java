package multithreading.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchUsage {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        List<Thread> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Thread t = new Thread(new Worker(latch, Integer.toString(i)));
            list.add(t);
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread after count down latch finished.");
    }
}

class Worker implements Runnable{
    CountDownLatch latch;
    String name;
    Worker(CountDownLatch latch, String name){
        this.latch = latch;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Thread "+name+": init");
        latch.countDown();
        try {
            System.out.println("Thread "+name+" before wait");
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+name+" after thread await finished.");
    }
}
