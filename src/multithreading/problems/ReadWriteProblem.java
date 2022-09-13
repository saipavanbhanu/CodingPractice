package multithreading.problems;


/* Reader can enter critical section when other readers are already there in critical section. ( and also no writer should be there )
 * When a writer acquires the lock no other reader can enter the critical section.
 * */

public class ReadWriteProblem {
	public static void main(String[] args) {
		
		ReadWriteLock rwl = new ReadWriteLock();
		
		Thread reader1 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("Attempting to acquire the lock by r1");
					try {
						rwl.acquireReadLock();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Read lock acquired by r1");
					System.out.println("Data read by r1");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rwl.releaseReadLock();
				}
			}
		};
		
		Thread reader2 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("Attempting to acquire the lock by r2");
					try {
						rwl.acquireReadLock();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Read lock acquired by r2");
					System.out.println("Data read by r2");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rwl.releaseReadLock();
				}
			}
		};
		
		
		Thread writer1 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("Attempting to acquire the lock by w1");
					try {
						rwl.acquireWriteLock();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("write lock acquired by w1");
					System.out.println("Data written by w1");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rwl.releaseWriteLock();
				}
			}
		};
		
		reader1.start();
		reader2.start();
		writer1.start();
		
	}
}

class ReadWriteLock {
	int readers;
	boolean isWriterLocked;
	
	public ReadWriteLock() {
		// TODO Auto-generated constructor stub
		readers = 0;
		isWriterLocked = false;
	}

	public synchronized void acquireReadLock() throws InterruptedException {

		if (isWriterLocked == true) {
			wait();
		}
		readers++;
	}

	public synchronized void releaseReadLock() {
		readers--;
		notifyAll();
	}

	public synchronized void acquireWriteLock() throws InterruptedException {
		if(isWriterLocked == true || readers > 0) {
			wait();
		}
		isWriterLocked = true;
	}
	
	public synchronized void releaseWriteLock() {
		isWriterLocked = false;
		notifyAll();
	}
	
}