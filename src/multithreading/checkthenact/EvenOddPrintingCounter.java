package multithreading.checkthenact;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

class Counter {
	final int max;
	int i;

	Counter(int max, int c) {
		this.max = max;
		this.i = c;
	}
}

class OddThread extends Thread {
	Semaphore s;
	Counter c;
	AtomicBoolean isEven;

	OddThread(Semaphore s, Counter c, AtomicBoolean isEven) {
		this.s = s;
		this.c = c;
		this.isEven = isEven;
	}

	@Override
	public void run() {
		while (c.i < c.max) {
			while (isEven.get() == true) {
				//continue in while loop.
			}
			try {
				s.acquire();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Odd: " + c.i);
			c.i++;
			isEven.compareAndSet(false, true);
			s.release();
		}
	}
}

class EvenThread extends Thread {
	Semaphore s;
	Counter c;
	AtomicBoolean isEven;

	EvenThread(Semaphore s, Counter c, AtomicBoolean isEven) {
		this.s = s;
		this.c = c;
		this.isEven = isEven;
	}

	@Override
	public void run() {
		while (c.i < c.max) {
			while (isEven.get() == false) {
				//continue in while loop.
			}
			try {
				s.acquire();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Even: " + c.i);
			c.i++;
			isEven.compareAndSet(true, false);
			s.release();
		}
	}
}


public class EvenOddPrintingCounter {
	public static void main(String[] args) {
		AtomicBoolean isEven = new AtomicBoolean(true);
		Counter c = new Counter(10, 0);
		Semaphore s = new Semaphore(1);
		OddThread oddThread = new OddThread(s, c, isEven);
		EvenThread evenThread = new EvenThread(s, c, isEven);
		oddThread.start();
		evenThread.start();

		try {
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Main thread ended");
	}
}
