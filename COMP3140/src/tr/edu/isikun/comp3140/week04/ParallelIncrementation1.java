package tr.edu.isikun.comp3140.week04;

public class ParallelIncrementation1 {
	private static final int THREADS = 10;
	private static final int INCREMENTATIONS = 10;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS];
		do {
			ThreadedCounter1.resetCounter();
			for (int i = 0; i < THREADS; i++) {
				threads[i] = new Thread(new ThreadedCounter1(INCREMENTATIONS));
			}
			for (int i = 0; i < THREADS; i++) {
				threads[i].start();
			}			
			for (int i = 0; i < THREADS; i++) {
				threads[i].join();
			}			
			System.out.println(ThreadedCounter1.getCounter());
		} while (ThreadedCounter1.getCounter() == THREADS * INCREMENTATIONS);
	}

}
