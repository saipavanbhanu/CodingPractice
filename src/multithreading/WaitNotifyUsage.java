package multithreading;

public class WaitNotifyUsage {
	public static void main(String[] args) throws InterruptedException {
		TotalEarnings te = new TotalEarnings();
		te.start();
		synchronized (te) {
			te.wait();
			System.out.println("Total: "+te.total);
		}
		
	}
}

class TotalEarnings extends Thread{
	int total = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			total = total + 100;
		}
		synchronized (this) {
			this.notify();
		}
	}
}