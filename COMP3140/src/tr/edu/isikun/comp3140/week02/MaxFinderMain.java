package tr.edu.isikun.comp3140.week02;

public class MaxFinderMain {
	public static final int ARRAY_SIZE = 100;
	public static double[] array;

	public static void main(String[] args) throws InterruptedException {
		initArray();
		int mid = ARRAY_SIZE/2;
		Thread t1 = new Thread(new MaxFinder(array, 0, mid));
		t1.start();
		Thread t2 = new Thread(new MaxFinder(array, mid+1, ARRAY_SIZE-1));
		t2.start();
		t1.join();
		t2.join();
		System.out.println("DONE");
	}
	
	public static void initArray() {
		array = new double[ARRAY_SIZE];
		for (int i=0; i<ARRAY_SIZE; i++) {
			array[i] = Math.random();
		}
	}

}
