package multithreading;

public class ThreadUsage {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("Inside the thread");
			System.out.println("Thread name: "+Thread.currentThread().getName());
		});
		
		t.start();
		System.out.println("Thread name: "+Thread.currentThread().getName());
	}
	
	
}
