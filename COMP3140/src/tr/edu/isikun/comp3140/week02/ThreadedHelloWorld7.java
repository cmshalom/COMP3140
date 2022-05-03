package tr.edu.isikun.comp3140.week02;

public class ThreadedHelloWorld7 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadedCounter7());
		t1.start();
		Thread t2 = new Thread(new ThreadedCounter7());
		t2.start();
		t1.interrupt();
		t1.join();
		t2.join();
		Thread me = Thread.currentThread();
		System.out.println("This is thread " + me);
	}

}
