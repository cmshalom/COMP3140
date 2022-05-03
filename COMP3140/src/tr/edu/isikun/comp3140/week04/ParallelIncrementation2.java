package tr.edu.isikun.comp3140.week04;

public class ParallelIncrementation2 {
	private static final int THREADS = 10;
	private static final int INCREMENTATIONS = 10;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS];
		do {
			ThreadedCounter2.resetCounter();
			for (int i = 0; i < THREADS; i++) {
				threads[i] = new Thread(new ThreadedCounter2(INCREMENTATIONS));
			}
			for (int i = 0; i < THREADS; i++) {
				threads[i].start();
			}			
			for (int i = 0; i < THREADS; i++) {
				threads[i].join();
			}			
			System.out.println(ThreadedCounter2.getCounter());
		} while (ThreadedCounter2.getCounter() == THREADS * INCREMENTATIONS);
	}

}
