package multithreading.problems;


/*
* After implementing this we would be having clear cut picture of cyclic barrier, semaphore, Reentrant Lock.
* */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {
    CyclicBarrier barrier = new CyclicBarrier(4);
    int republicans = 0;
    int democrats = 0;
    Semaphore demsWaiting = new Semaphore(0);
    Semaphore repsWaiting = new Semaphore(0);
    ReentrantLock lock = new ReentrantLock();

    public void seatDemocrat(){
        lock.lock();
        boolean ride = false;
        democrats++;
        if(democrats == 4){
            demsWaiting.release(3);
            ride = true;
            democrats -= 4;
        }else if(democrats == 2 && republicans >= 2){
            demsWaiting.release(1);
            repsWaiting.release(2);
            ride = true;
            democrats = democrats - 2;
            republicans = republicans - 2;
        }else{
            lock.unlock();
            try {
                demsWaiting.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        seated();
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        if(ride == true){
            drive();
            lock.unlock();
        }

    }
    void drive() {
        System.out.println("Uber Ride on Its wayyyy... with ride leader " + Thread.currentThread().getName());
        System.out.flush();
    }

    void seated() {
        System.out.println(Thread.currentThread().getName() + " seated");
        System.out.flush();
    }

    public void seatRupublican(){
        lock.lock();
        boolean ride = false;
        republicans++;
        if(republicans == 4){
            repsWaiting.release(3);
            ride = true;
            republicans -= 4;
        }else if(democrats >= 2 && republicans == 2){
            repsWaiting.release(1);
            demsWaiting.release(2);
            ride = true;
            republicans = republicans - 2;
            democrats = democrats - 2;
        }else{
            lock.unlock();
            try {
                repsWaiting.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        seated();
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        if(ride == true){
            drive();
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        runTest();
    }

    public static void runTest(){
        final UberSeatingProblem uber = new UberSeatingProblem();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    uber.seatDemocrat();
                }
            });
            t.setName("Democrat_"+i);
            threads.add(t);
            t.start();

        }

        for(int i = 0; i < 14; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    uber.seatRupublican();
                }
            });
            t.setName("Republican_"+i);
            threads.add(t);
            t.start();

        }

        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
