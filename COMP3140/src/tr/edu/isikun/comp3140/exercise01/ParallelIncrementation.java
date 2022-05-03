package tr.edu.isikun.comp3140.exercise01;

public class ParallelIncrementation {
	private static final int THREADS = 10;
	private static final int INCREMENTATIONS = 10;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS];
		do {
			ThreadedCounter.resetCounter();
			for (int i = 0; i < THREADS; i++) {
				threads[i] = new Thread(new ThreadedCounter(INCREMENTATIONS));
			}
			for (int i = 0; i < THREADS; i++) {
				threads[i].start();
			}			
			for (int i = 0; i < THREADS; i++) {
				threads[i].join();
			}			
			System.out.println(ThreadedCounter.getCounter());
		} while (ThreadedCounter.getCounter() == THREADS * INCREMENTATIONS);
	}

}
