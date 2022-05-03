package tr.edu.isikun.comp3140.week03;

import java.util.concurrent.Callable;

public class MaxFinder implements Callable<Double> {
	private double[] array;
	private int low;
	private int high;
	
	public MaxFinder(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	public MaxFinder(double[] array) {
		this(array, 0, array.length-1);
	}
	
	@Override
	public Double call() throws Exception {
		double max = Double.MIN_VALUE;
		for (int i=low; i<=high; i++) {
			if (array[i] > max) max = array[i];
		}
		return max;
	}
}
