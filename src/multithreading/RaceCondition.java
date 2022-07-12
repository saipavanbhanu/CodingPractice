package multithreading;

import java.util.Random;

public class RaceCondition {
	public static void main(String args[]) throws InterruptedException {
		RC.runTest();
	}
}

class RC {
	int randInt;
	Random random = new Random(System.currentTimeMillis());

	void printer() {
		int i = 1000000;
		while (i != 0) {
			if (randInt % 5 == 0) {
				if (randInt % 5 != 0)
					System.out.println(randInt);
			}
			i--;
		}
	}

	void modifier() {
		int i = 1000000;
		while (i != 0) {
			randInt = random.nextInt(1000);
			i--;
		}
	}

	public static void runTest() throws InterruptedException {
		System.out.println("before thread");
		final RC rc = new RC();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				rc.printer();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				rc.modifier();
			}
		});
		thread1.start();
		System.out.println("After thread start");
		thread2.start();
		thread1.join();
		thread2.join();
	}
	
}