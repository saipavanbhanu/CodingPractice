package multithreading.problems;

public class BlockingQueueUsage {
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> bq = new BlockingQueue<>(25);
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 50; i++) {
					try {
						bq.enqueue(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 25; i++) {
					try {
						bq.deque();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t3 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 25; i++) {
					try {
						bq.deque();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		t1.start();
		Thread.sleep(1000 * 4);
		t2.start();
		
		t2.join();
		t3.start();
		t1.join();
		t3.join();
		
	}
}
