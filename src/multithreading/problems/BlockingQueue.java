package multithreading.problems;

public class BlockingQueue<T> {
	T[] array;
	int size;
	int capacity;
	int head, tail;
	
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
		size = 0;
		array = (T[]) new Object[capacity];
		head = tail = -1;
	}
	public synchronized void enqueue(T obj) throws InterruptedException {
		if(size == capacity) {
			wait();
		}
		
		if(head == tail && head == -1) {
			head = 0;
		}
		tail = ( tail + 1 ) % capacity;
		array[tail] = obj;
		System.out.println("Enqueue Thread: "+Thread.currentThread().getName()+" item: "+obj.toString());
		size++;
		notifyAll();
	}
	
	public synchronized T deque() throws InterruptedException {
		if(size == 0) {
			wait();
		}
		T element = null;
		if(size == 1) {
			element = array[head];
			size--;
			head = tail = -1;
		}else {
			element = array[head];
			head = ( head + 1 ) % capacity;
			size--;
		}
		System.out.println("Deque Thread: "+Thread.currentThread().getName()+" item: "+element.toString());
		notifyAll();
		return element;
	}
	
}
