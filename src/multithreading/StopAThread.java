package multithreading;

public class StopAThread {

	static class MyRunnable implements Runnable {

		private boolean doStop = false;

		public synchronized void doStop() {
			System.out.println("Cleaning up the resources");
			this.doStop = true;
			System.out.println("stopping the thread");
		}

		private synchronized boolean keepRunning() {
			return this.doStop == false;
		}

		@Override
		public void run() {
			while (keepRunning()) {
				// keep doing what this thread should do.
				System.out.println("Running");

				try {
					Thread.sleep(3L * 1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();

		Thread thread = new Thread(myRunnable);

		thread.start();

		try {
			Thread.sleep(10L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		myRunnable.doStop();
	}

}
