package multithreading;

public class StopAThread {

	static class MyThread extends Thread {
		private boolean doStop = false;

		public synchronized void doStop() {
			doStop = true;
		}

		public boolean keepRunning() {
			return doStop == false;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (keepRunning()) {
				System.out.println("Running the thread");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cleanUp();
			System.out.println("Last statement of the thread");
		}
		public void cleanUp() {
			System.out.println("cleaning up the resources");
		}
	}

	public static void main(String[] args) throws InterruptedException {

		MyThread t = new MyThread();
		t.start();
		Thread.sleep(5000);
		t.doStop();
		System.out.println("Last statement of the main thread");
	}

}
