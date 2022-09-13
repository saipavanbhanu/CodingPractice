package multithreading;

public class CreatingAThread {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("Inside the thread");
			System.out.println("Thread name: "+Thread.currentThread().getName());
		});
		
		t.start();
		System.out.println("Thread name: "+Thread.currentThread().getName());
	}
	
	
}
