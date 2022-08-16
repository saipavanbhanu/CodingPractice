package multithreading.volatileUsage;

class Counter {
	int count;
	
	public synchronized int incCount() {
		return ++count;
	}
	
	public int getCount() {
		return count;
	}
	
}
