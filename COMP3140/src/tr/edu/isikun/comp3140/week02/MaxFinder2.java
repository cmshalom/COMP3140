package tr.edu.isikun.comp3140.week02;

public class MaxFinder2 implements Runnable {
	private double[] array;
	private int low;
	private int high;
	private double max = 0;
	
	
	public MaxFinder2(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	@Override
	public void run() {
		for (int i=low; i<=high; i++) {
			if (array[i] > max) max = array[i];
		}
	}

	public double getMax() {
		return max;
	}
	
}
