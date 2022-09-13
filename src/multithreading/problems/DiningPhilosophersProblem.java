package multithreading.problems;

import java.util.concurrent.Semaphore;

/*Dining philosophers problem can be solved if we use only allow max 4 diners if we have five forks/philosophers  
 * in that way there is always one fork free for other philosopher to eat and contemplate */


public class DiningPhilosophersProblem {

	Semaphore[] forks = new Semaphore[5];
	Semaphore maxDiners = new Semaphore(4);

	public DiningPhilosophersProblem() {
		for (int i = 0; i < 5; i++) {
			forks[i] = new Semaphore(1);
		}
	}

	public void lifecycleOfPhilosopher(int id) throws InterruptedException {
		while (true) {
			contemplate();
			eat(id);
		}
	}

	void eat(int i) throws InterruptedException {
		maxDiners.acquire();

		forks[i].acquire();
		forks[(i + 4) % 5].acquire();
		System.out.println("Philosopher " + i + " is eating");
		forks[i].release();
		forks[(i + 4) % 5].release();

		maxDiners.release();
	}

	void contemplate() throws InterruptedException {
		Thread.sleep(500);
	}

	static void startPhilosoper(DiningPhilosophersProblem dp, int id) {
		try {
			dp.lifecycleOfPhilosopher(id);
		} catch (InterruptedException ie) {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final DiningPhilosophersProblem dp = new DiningPhilosophersProblem();
		
		Thread p1 = new Thread(new Runnable() {
			public void run() {
				startPhilosoper(dp, 0);
			}
		});
		Thread p2 = new Thread(new Runnable() {
			public void run() {
				startPhilosoper(dp, 1);
			}
		});
		Thread p3 = new Thread(new Runnable() {
			public void run() {
				startPhilosoper(dp, 2);
			}
		});
		Thread p4 = new Thread(new Runnable() {
			public void run() {
				startPhilosoper(dp, 3);
			}
		});
		Thread p5 = new Thread(new Runnable() {
			public void run() {
				startPhilosoper(dp, 4);
			}
		});
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
		p1.join();
		p2.join();
		p3.join();
		p4.join();
		p5.join();
		
	}
}
