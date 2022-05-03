package tr.edu.isikun.comp3140.week06;

public class ParallelTransfer {
	private static final int THREADS = 2;
	private static final int TRANSFERS = 10;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS];
		Account account1 = new Account();
		Account account2 = new Account();
		long grandBalance = 0;
		do {
		    threads[0] = new Thread(new Transfer(account1, account2, TRANSFERS));
		    threads[1] = new Thread(new Transfer(account2, account1, TRANSFERS));
			for (int i = 0; i < THREADS; i++) {
				threads[i].start();
			}			
			for (int i = 0; i < THREADS; i++) {
				threads[i].join();
			}			
			grandBalance = account1.getBalance() + account2.getBalance();
			System.out.println(account1.getBalance() + " " + account2.getBalance() + " " + grandBalance);
		} while (grandBalance == 0);
	}

}
