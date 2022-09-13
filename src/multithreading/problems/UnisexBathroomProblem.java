package multithreading.problems;

import java.util.Random;
import java.util.concurrent.Semaphore;

/*Solution not working*/

public class UnisexBathroomProblem {

	public static void main(String[] args) {
		UnisexBathRoom obj = new UnisexBathRoom(3);
		
		for(int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					Random r = new Random();
					int i = r.nextInt();
					if(i % 2 == 0) {
						try {
							obj.useBathroomByMale(Sex.MALE, String.valueOf(i));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						try {
							obj.useBathroomByFemale(Sex.FEMALE, String.valueOf(i));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			t.start();
		}
	}

}

class UnisexBathRoom {
	Sex inUseBy;
	Semaphore capacity;
	Semaphore lock; //lock of the unisex bathroom object
	int size; // no of persons already present in the bathroom

	public UnisexBathRoom(int capacity) {
		inUseBy = Sex.NONE;
		this.capacity = new Semaphore(capacity);
		size = 0;
		lock = new Semaphore(1);
	}

	public void useBathroomByMale(Sex user, String name) throws InterruptedException {
		lock.acquire();
		while(inUseBy == Sex.FEMALE) {
			lock.release();
			wait();
			lock.acquire();
		}
		lock.release();
		
		
		lock.acquire();
			System.out.println("Male:"+name + " trying to enter bathroom");
			capacity.acquire();
			inUseBy = user;
			System.out.println("Male:"+name + " entered the bathroom");
			size++;
		lock.release();
		
		System.out.println("Male:"+name + " using the bathroom");
		Thread.sleep(1000);

		lock.acquire();
			capacity.release();
			size--;
			if (size == 0)
				inUseBy = Sex.NONE;
			notifyAll();
		lock.release();
		
		System.out.println("Male:"+name + " leaving the bathroom");
	}
	
	public void useBathroomByFemale(Sex user, String name) throws InterruptedException {
		lock.acquire();
		while(inUseBy == Sex.MALE) {
			lock.release();
			wait();
			lock.acquire();
		}
		lock.release();
		
		
		lock.acquire();
			System.out.println("Male:"+name + " trying to enter bathroom");
			capacity.acquire();
			inUseBy = user;
			System.out.println("Male:"+name + " entered the bathroom");
			size++;
		lock.release();
		
		System.out.println("Male:"+name + " using the bathroom");
		Thread.sleep(1000);

		lock.acquire();
			capacity.release();
			size--;
			if (size == 0)
				inUseBy = Sex.NONE;
			notifyAll();
		lock.release();
		
		System.out.println("Male:"+name + " leaving the bathroom");
	}
}

enum Sex {
	MALE, FEMALE, NONE;
}
