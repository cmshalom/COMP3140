package tr.edu.isikun.comp3140.week05;

public class Account {
	private long balance = 0;
	
	public long getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int amount) throws InterruptedException {
//			System.out.println("Thread " + Thread.currentThread().getId() + " acquired lock for " + this + " to withdraw");
//			TimeUnit.MILLISECONDS.sleep(10);
			balance -= amount;			
	}
	
	public synchronized void deposit(int amount) throws InterruptedException {
//			System.out.println("Thread " + Thread.currentThread().getId() + " acquired lock for " + this + " to deposit");
//			TimeUnit.MILLISECONDS.sleep(10);
			balance += amount;			
	}
}
