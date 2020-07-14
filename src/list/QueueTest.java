package list;

import java.util.concurrent.locks.ReentrantLock;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue(6);
		new Thread(()-> {
			for(int i = 0; i < 100; i++) {
				System.out.println(q.add(i + 1));
			}
		}).start();
		new Thread(()-> {
			for(int i = 0; i < 100; i++) {
				System.out.println(q.pull());
			}
		}).start();
	}

}




class MyQueue{
	
	ReentrantLock lock = new ReentrantLock();
	
	private int [] arr;
	private int front;
	private int tail;
	private int queueSize;
	
	public MyQueue(int size) {
		if(size <= 0)
			size = 10;
		queueSize = size;
		arr = new int[queueSize];
		front = 0;
		tail = 0;
	}
	
	public boolean isEmpty() {
		return front == tail;
	}
	
	public boolean isFull() {
		return (tail + 1) % queueSize == front;
	}
	
	public synchronized boolean add(int i) {
		if(isFull())
			return false;
		arr[tail] = i;
		tail = (tail + 1) % queueSize;
		return true;
	}
	
	public synchronized int pull() {
		if(isEmpty())
			return Integer.MAX_VALUE;
		int res = arr[front];
		front = (front + 1) % queueSize;
		return res;
	}
	
}
