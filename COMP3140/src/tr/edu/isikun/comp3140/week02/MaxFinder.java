package tr.edu.isikun.comp3140.week02;

public class MaxFinder implements Runnable {
	private double[] array;
	private int low;
	private int high;
	
	public MaxFinder(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	@Override
	public void run() {
		double max = 0;
		for (int i=low; i<=high; i++) {
			if (array[i] > max) max = array[i];
		}
		System.out.println("Max:" + max);
	}
	
}
