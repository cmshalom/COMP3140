package tr.edu.isikun.comp3140.week04;

import java.util.Queue;

public class ConsumerWaiting implements Runnable {
	Queue<Integer> queue;

	public ConsumerWaiting(Queue<Integer> queue) {
		this.queue = queue;		
	}

	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				if (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int i = queue.poll();
					System.out.println("CONSUMING:" + i);
				}
			}
		}
	}

}
