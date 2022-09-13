package multithreading.criticalsection;

public class CounterSharedState {

	static class Counter{
		int count;
		Counter(){
			this.count = 0;
		}
		synchronized int incrementCount() {
			return ++this.count;
		}
		int getCount() {
			return this.count;
		}
	}
	
	
	public static void main(String[] args) {
		Counter c = new Counter();
		Thread t1 = new Thread(getRunnable(c));
		Thread t2 = new Thread(getRunnable(c));
		t1.start();
		t2.start();
		
	}
	static Runnable getRunnable(Counter c) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 1_000_000; i++) {
					c.incrementCount();
				}
				System.out.println(Thread.currentThread().getName()+": "+c.getCount());
			}
		};
		
		return r;
	}
	
}
