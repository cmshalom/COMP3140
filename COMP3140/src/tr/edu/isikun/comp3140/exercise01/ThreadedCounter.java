package tr.edu.isikun.comp3140.exercise01;

public class ThreadedCounter implements Runnable {
	private static int counter = 0;

	private int numberOfIncrementations;
	
	public ThreadedCounter(int numberOfIncrementations) {
		this.numberOfIncrementations = numberOfIncrementations;
	}

	@Override
	public void run() {
		int myCopyOfCounter;
		for (int i=0; i < numberOfIncrementations; i++) {
			myCopyOfCounter = counter;
			myCopyOfCounter++;
			counter=myCopyOfCounter;
		}
	}

	public static int getCounter() {
		return counter;
	}
	
	public static void resetCounter() {
		counter = 0;
	}

}
