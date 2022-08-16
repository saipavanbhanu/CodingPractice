package multithreading.volatileUsage;

class Counter {
	public volatile int count = 0;
	
	public boolean incCount() {
		if(count == 10) {
			return false;
		}
		++count;
		return true;
	}
	
	public int getCount() {
		return count;
	}
	
}
