package tr.edu.isikun.comp3140.week05;

public class ParallelTransfer {
	private static final int THREADS = 2;
	private static final int ACCOUNTS = 2;
	private static final int TRANSFERS = 10;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS];
		Account[] accounts = new Account[ACCOUNTS];
		for (int i = 0; i < ACCOUNTS; i++) {
			accounts[i] = new Account();
		}			
		long grandBalance = 0;
		do {
			for (int i = 0; i < THREADS; i++) {
			    threads[i] = new Thread(new Transfer(accounts[i], accounts[(i+1) % ACCOUNTS], TRANSFERS));
			}
			for (int i = 0; i < THREADS; i++) {
				threads[i].start();
			}			
			for (int i = 0; i < THREADS; i++) {
				threads[i].join();
			}			
			grandBalance = 0;
			for (int i = 0; i < THREADS; i++) {
				System.out.print(accounts[i].getBalance() + " ");
				grandBalance += accounts[i].getBalance();
			}
		} while (grandBalance == 0);
		System.out.println(grandBalance);
	}

}
