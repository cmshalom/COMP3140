package tr.edu.isikun.comp3140.week01;

public class ThreadedCounter2 implements Runnable {

	@Override
	public void run() {
		for (int i=0; i < 10; i++) {
			System.out.println("This is thread " + this + "i=" +i);
		}
	}

}
