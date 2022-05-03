package tr.edu.isikun.comp3140.week01;

public class ThreadedHelloWorld5 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadedCounter5());
		t1.start();
		Thread t2 = new Thread(new ThreadedCounter5());
		t2.start();
		Thread me = Thread.currentThread();
		System.out.println("This is thread " + me);
	}

}
