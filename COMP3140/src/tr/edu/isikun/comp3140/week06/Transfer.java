package tr.edu.isikun.comp3140.week06;

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
			try {
				source.lock();
				try {
					destination.lock();
					source.withdraw(x);
					destination.deposit(x);
				} catch (Exception e) {
					System.err.println("Aborting...");
				} finally {
					destination.unlock();
				}
			} catch (Exception e) {
				System.err.println("Aborting...");
			} finally {
				source.unlock();					
			}
		}
	}
}
