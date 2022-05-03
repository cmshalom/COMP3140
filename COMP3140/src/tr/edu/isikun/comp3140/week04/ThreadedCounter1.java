package tr.edu.isikun.comp3140.week04;

public class ThreadedCounter1 implements Runnable {
	private static Integer counter = 0;
	
	private int numberOfIncrementations;
	
	public ThreadedCounter1(int numberOfIncrementations) {
		this.numberOfIncrementations = numberOfIncrementations;
	}

	@Override
	public void run() {
		int myCopyOfCounter;
		for (int i=0; i < numberOfIncrementations; i++) {
			// synchronized (counter) { DID NOT WORK  
			synchronized (ThreadedCounter1.class) {  
				myCopyOfCounter = counter;
				myCopyOfCounter++;
				counter = myCopyOfCounter; 	// counter = new Integer(myCopyOfCounter);
			}
		}
	}

	public static int getCounter() {
		return counter;
	}
	
	public static void resetCounter() {
		counter = 0;
	}

}
