package multithreading.checkthenact;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooThread extends Thread{
    AtomicBoolean flag;
    Lock lock;
    FooThread(AtomicBoolean flag, Lock lock){
        this.flag = flag;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            while (flag.get() == true) {

            }
            lock.lock();
            System.out.println("Foo");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag.compareAndSet(false, true);
            lock.unlock();
        }
    }
}

class BarThread extends Thread{
    AtomicBoolean flag;
    Lock lock;
    BarThread(AtomicBoolean flag, Lock lock){
        this.flag = flag;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){

            while(flag.get() == false){

            }
            lock.lock();
            System.out.println("Bar");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag.compareAndSet(true, false);
            lock.unlock();
        }
    }
}


public class FooBarAlternatePrinting {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(false);
        Lock lock = new ReentrantLock();
        FooThread fooThread = new FooThread(flag, lock);
        BarThread barThread = new BarThread(flag, lock);
        fooThread.start();
        barThread.start();

        try{
            fooThread.join();
            barThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread finished");
    }
}
