package geeksforgeeks.queue;

public class CircularQueueArray {
    int front, rear, size, capacity;
    int arr[];
    CircularQueueArray(int capacity){
        this.capacity = capacity;
        this.front = 0;
        this.rear = capacity - 1;
        this.size = 0;
        this.arr = new int[capacity];
    }
    public boolean isFull(){
        return size == capacity;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue's capacity is full");
            return;
        }
        rear = ( rear + 1 ) % capacity;
        arr[rear] = data;
        size = size + 1;
    }
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Queue is already empty");
            return Integer.MAX_VALUE;
        }
        int x = arr[front];
        front = ( front + 1 )%capacity;
        size = size - 1;
        return x;
    }
    public static void main(String [] args){
        CircularQueueArray queue = new CircularQueueArray(1000);

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);

        System.out.println(queue.deQueue() +
                " dequeued from queue\n");

    }
}
