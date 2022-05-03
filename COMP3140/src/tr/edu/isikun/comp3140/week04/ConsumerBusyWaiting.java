package tr.edu.isikun.comp3140.week04;

import java.util.Queue;

public class ConsumerBusyWaiting implements Runnable {
	Queue<Integer> queue;

	public ConsumerBusyWaiting(Queue<Integer> queue) {
		this.queue = queue;		
	}

	@Override
	public void run() {
		while(true) {
			if (! queue.isEmpty()) { // BUSY WAITING
				int i = queue.poll();
				System.out.println("CONSUMING" + i);
			} 
		}
	}

}
