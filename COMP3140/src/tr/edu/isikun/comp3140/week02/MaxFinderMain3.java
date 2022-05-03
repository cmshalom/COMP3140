package tr.edu.isikun.comp3140.week02;

public class MaxFinderMain3 {
	public static final int ARRAY_SIZE = 100;
	public static final int FINDERS = 2;
	public static double[] array;

	public static void main(String[] args) throws InterruptedException {
		initArray();
		int sizeOfOne = ARRAY_SIZE/FINDERS;

		MaxFinder3[] finders = new MaxFinder3[FINDERS];
		Thread[] threads = new Thread[FINDERS];
		double[] maxima = new double[FINDERS];
		
		for(int i=0; i<FINDERS; i++) {
			int high = i < (FINDERS-1) ? (i+1) * sizeOfOne - 1 : ARRAY_SIZE-1;
	        finders[i] = new MaxFinder3(array, i * sizeOfOne, high);
			threads[i] = new Thread(finders[i]);
			threads[i].start();
		}
		for(int i=0; i<FINDERS; i++) {
			threads[i].join();
			maxima[i] = finders[i].getMax();
		}
		
		MaxFinder3 eventualFinder = new MaxFinder3(maxima);
		Thread t = new Thread(eventualFinder);
		t.start();
		t.join();
		System.out.println("MAX=" + eventualFinder.getMax());
	}
	
	public static void initArray() {
		array = new double[ARRAY_SIZE];
		for (int i=0; i<ARRAY_SIZE; i++) {
			array[i] = Math.random();
		}
	}

}
