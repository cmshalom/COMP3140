package tr.edu.isikun.comp3140.week04;

public class ThreadedCounter2 implements Runnable {
	private static Integer counter = 0;
	
	private int numberOfIncrementations;
	
	public ThreadedCounter2(int numberOfIncrementations) {
		this.numberOfIncrementations = numberOfIncrementations;
	}

	@Override
	public void run() {
		for (int i=0; i < numberOfIncrementations; i++) {
			increment();
		}
	}

	private static synchronized void increment() {
		int myCopyOfCounter;
		
		myCopyOfCounter = counter;
		myCopyOfCounter++;
		counter = myCopyOfCounter; 	// counter = new Integer(myCopyOfCounter);
	}

	public static int getCounter() {
		return counter;
	}
	
	public static void resetCounter() {
		counter = 0;
	}

}
