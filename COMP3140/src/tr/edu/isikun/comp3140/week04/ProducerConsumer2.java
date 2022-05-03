package tr.edu.isikun.comp3140.week04;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer2 {
	private static final int THREADS = 2;
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS];
		Queue<Integer> queue = new LinkedList<>();
		
		ProducerSlowNotifying producer = new ProducerSlowNotifying(queue);
		ConsumerWaiting consumer = new ConsumerWaiting(queue);
		
		threads[0] = new Thread(producer);
		threads[1] = new Thread(consumer);
		for (int i = 0; i < THREADS; i++) {
			threads[i].start();
		}			
		for (int i = 0; i < THREADS; i++) {
			threads[i].join();
		}			
		System.out.println("DONE");
	}

}
