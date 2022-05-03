package tr.edu.isikun.comp3140.week01;

public class ThreadedCounter4 implements Runnable {
	private static int counter = 0;

	@Override
	public void run() {
		int myCopyOfCounter;
		for (int i=0; i < 10; i++) {
			myCopyOfCounter = counter;
			myCopyOfCounter++;
			counter=myCopyOfCounter;
			System.out.println("This is thread " + this + ", i=" + i + ",counter=" + counter);
		}
	}

}
