package tr.edu.isikun.comp3140.week03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxFinderWithExecutor {
	private static double[] data = {1.1, 4.0, 3, 20, 19, 11, 27, 3};
	
    public static void main (String[] args) throws InterruptedException, ExecutionException {
    	MaxFinder finder1 = new MaxFinder(data, 0, data.length/2);
    	MaxFinder finder2 = new MaxFinder(data, data.length/2+1, data.length-1);
    	
    	ExecutorService service = Executors.newFixedThreadPool(2);
    	
    	Future<Double> future1 = service.submit(finder1);
    	Future<Double> future2 = service.submit(finder2);
    	
    	System.out.println(Math.max(future1.get(), future2.get()));
    	service.shutdown();
    }
}
