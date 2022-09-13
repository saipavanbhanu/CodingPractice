package multithreading.problems;

import java.util.concurrent.Semaphore;

class Queue<T>{
	int capacity;
	T[] array;
	int size;
	Semaphore producer, consumer;
	int head, tail;
	public Queue(int capacity, Semaphore producer, Semaphore consumer) {
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
		this.size = 0;
		this.producer = producer;
		this.consumer = consumer;
		head = tail = -1;
	}
	
	public void enqueue(T element) {
		try {
			producer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( head == tail && head == -1) {
			head = tail = 0;
			array[head] = element;
		}else {
			tail = ( tail + 1) % capacity;
			array[tail] = element;
		}
		System.out.println("produced item: "+element);
		consumer.release();
	}
	
	public T deque() {
		try {
			consumer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		T element = null;
		if(head == tail) {
			element = array[head];
			head = tail = -1;
		}else {
			element = array[head];
			head = ( head + 1 ) % capacity;
		}
		System.out.println("consumed item: "+element);
		producer.release();
		return element;
	}
	
}

public class BoundedBufferUsingSemaphore {

	public static void main(String[] args) {
		
		int bufferSize = 10;
		Semaphore producer = new Semaphore(bufferSize);
		Semaphore consumer = new Semaphore(0);
		Queue<Integer> q = new Queue(bufferSize, producer, consumer);
		
		Thread producerThread = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					q.enqueue(i);
				}
			}
		};
		
		Thread consumerThread = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					q.deque();
				}
			}
		};
		
		producerThread.start();
		consumerThread.start();
		
		
		
	}

}
