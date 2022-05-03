package tr.edu.isikun.comp3140.week02;

public class MaxFinder3 implements Runnable {
	private double[] array;
	private int low;
	private int high;
	private double max = 0;
	
	
	public MaxFinder3(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	public MaxFinder3(double[] array) {
		this(array, 0, array.length-1);
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
