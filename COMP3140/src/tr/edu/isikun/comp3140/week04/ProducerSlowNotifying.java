package tr.edu.isikun.comp3140.week04;

import java.util.Queue;

public class ProducerSlowNotifying implements Runnable {
	Queue<Integer> queue;

	public ProducerSlowNotifying(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int i = (int) (Math.random() * 100);
			synchronized (queue) {
				queue.add(i);
				System.out.println("PRODUCING:" + i);
				System.out.println(queue.size() + " ITEMS IN QUEUE");
				queue.notify();
			}
		}
	}

}
