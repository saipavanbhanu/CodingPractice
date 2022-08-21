package multithreading.problems;
class OddThread extends Thread{
	Counter c;
	public OddThread(Counter c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		while(c.count < 100) {
			synchronized (c) {
				System.out.println("Odd Thread: "+c.count);
				c.incCount();
				try {
					c.notify();
					c.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class EvenThread extends Thread{
	Counter c;
	public EvenThread(Counter c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		while(c.count < 100) {
			synchronized (c) {
				System.out.println("Even Thread: "+c.count);
				c.incCount();
				try {
					c.notify();
					c.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Counter{
	int count;
	void incCount() {
		count++;
	}
}


public class EvenOddPrinting {
	public static void main(String[] args) {
		
		Counter c = new Counter();
		EvenThread et = new EvenThread(c);
		OddThread ot = new OddThread(c);
		et.start();
		ot.start();
		
		
	}
}

