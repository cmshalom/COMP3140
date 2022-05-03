package tr.edu.isikun.comp3140.week01;

public class ThreadedCounter3 implements Runnable {
	private static int counter = 0;

	@Override
	public void run() {
		for (int i=0; i < 10; i++) {
			counter++;
			System.out.println("This is thread " + this + ", i=" + i + ",counter=" + counter);
		}
	}

}
