package tr.edu.isikun.comp3140.week05;

public class Transfer implements Runnable {
	private static final int MAX_TRANSFER = 100;
	
	private Account source;
	private Account destination;
	private int numberOfTransfers;
	
	public Transfer(Account source, Account destination, int numberOfTransfers) {
		this.source = source;
		this.destination = destination;
		this.numberOfTransfers = numberOfTransfers;
	}

	@Override
	public void run() {
		for (int i = 0; i < numberOfTransfers; i++) {
			int x = (int) (Math.random() * MAX_TRANSFER);
			System.out.println("Thread " + Thread.currentThread().getId() + " started the transfer" );
			try {
				synchronized(source) {
					source.withdraw(x);
					synchronized (destination) {
						destination.deposit(x);						
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
