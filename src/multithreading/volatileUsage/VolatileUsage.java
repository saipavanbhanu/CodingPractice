package multithreading.volatileUsage;

public class VolatileUsage {

	public static void main(String[] args) {
		Counter c = new Counter();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 15; i++) {
					c.incCount();
				}
				System.out.println(Thread.currentThread().getName()+":"+c.getCount());
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 15; i++) {
					c.incCount();
				}
				System.out.println(Thread.currentThread().getName()+":"+c.getCount());
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
