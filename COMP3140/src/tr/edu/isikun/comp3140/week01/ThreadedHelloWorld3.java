package tr.edu.isikun.comp3140.week01;

public class ThreadedHelloWorld3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadedCounter3());
		t1.start();
		Thread t2 = new Thread(new ThreadedCounter3());
		t2.start();
	}

}
