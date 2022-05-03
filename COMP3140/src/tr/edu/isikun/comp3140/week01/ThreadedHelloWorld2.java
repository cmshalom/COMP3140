package tr.edu.isikun.comp3140.week01;

public class ThreadedHelloWorld2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadedCounter2());
		t1.start();
		Thread t2 = new Thread(new ThreadedCounter2());
		t2.start();
	}

}
