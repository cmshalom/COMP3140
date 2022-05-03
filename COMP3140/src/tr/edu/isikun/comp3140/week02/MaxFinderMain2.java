package tr.edu.isikun.comp3140.week02;

public class MaxFinderMain2 {
	public static final int ARRAY_SIZE = 100;
	public static double[] array;

	public static void main(String[] args) throws InterruptedException {
		initArray();
		int mid = ARRAY_SIZE/2;
		
		MaxFinder2 finder1 = new MaxFinder2(array, 0, mid);
		MaxFinder2 finder2 = new MaxFinder2(array, mid+1, ARRAY_SIZE-1);
		Thread t1 = new Thread(finder1);
		t1.start();
		Thread t2 = new Thread(finder2);
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("MAX=" + Math.max(finder1.getMax(), finder2.getMax()));
	}
	
	public static void initArray() {
		array = new double[ARRAY_SIZE];
		for (int i=0; i<ARRAY_SIZE; i++) {
			array[i] = Math.random();
		}
	}

}
