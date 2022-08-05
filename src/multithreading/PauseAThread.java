package multithreading;

/*
 * Wherever we write the Thread.sleep(3000) it will make the thread sleep for that specified amount of time.
 * it is the minimum amount of time for pausing a thread.
 * */

public class PauseAThread {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for(int i = 0; i < 2; i++) {
				System.out.println("before sleep");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < 2; i++) {
				System.out.println("after sleep");
			}
		});
		
		t.start();
		
	}

}
