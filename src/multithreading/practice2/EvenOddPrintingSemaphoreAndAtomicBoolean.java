package multithreading.practice2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

class Counter{
	int c = 0;
}


class EvenThread extends Thread{
	AtomicBoolean evenThread;
	Counter co;
	Semaphore s;
	EvenThread(AtomicBoolean c, Counter co, Semaphore s){
		this.evenThread = c;
		this.co = co;
		this.s = s;
	}
	@Override
	public void run(){
		for(int i = 0; i < 15; i++){
			while(!evenThread.compareAndSet(true, false)){

			}
			try {
				s.acquire();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(co.c);
			co.c++;
			s.release();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class OddThread extends Thread{
	AtomicBoolean evenThread;
	Counter co;
	Semaphore s;
	OddThread(AtomicBoolean c, Counter co, Semaphore s){
		this.evenThread = c;
		this.co = co;
		this.s = s;
	}
	@Override
	public void run(){
		for(int i = 0; i < 15; i++){
			while(!evenThread.compareAndSet(false, true)){

			}
			try {
				s.acquire();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(co.c);
			co.c++;
			s.release();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}


public class EvenOddPrintingSemaphoreAndAtomicBoolean {

	public static void main(String [] args){
		AtomicBoolean evenFlag = new AtomicBoolean(true);
		Counter c = new Counter();
		Semaphore s = new Semaphore(1);
		EvenThread evenThread = new EvenThread(evenFlag, c, s);
		OddThread oddThread = new OddThread(evenFlag, c, s);
		evenThread.start();
		oddThread.start();
	}


}
