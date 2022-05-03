package tr.edu.isikun.comp3140.week02;

public class ThreadedCounter7 implements Runnable {
	private static int counter = 0;

	@Override
	public void run() {
		int myCopyOfCounter;
		for (int i=0; i < 10; i++) {
			myCopyOfCounter = counter;
			myCopyOfCounter++;
			try {
				Thread.sleep(0, 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter=myCopyOfCounter;
			Thread me = Thread.currentThread();
			System.out.println("This is thread " + me + ", i=" + i + ",counter=" + counter);
		}
	}

}
