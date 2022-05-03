package tr.edu.isikun.comp3140.week06;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private long balance = 0;
	private ReentrantLock mutex = new ReentrantLock();

	public long getBalance() {
		return balance;
	}
	
	public void withdraw(int amount) throws InterruptedException {
		System.out.println("Thread" + Thread.currentThread().getId() + " acquired lock for " + this + " to withdraw");
		TimeUnit.SECONDS.sleep(1);
		balance -= amount;			
	}

	public void deposit(int amount) throws InterruptedException {
		System.out.println("Thread" + Thread.currentThread().getId() + " acquired lock for " + this + " to deposit");
		TimeUnit.SECONDS.sleep(1);
		balance += amount;			
	}
	
	public void lock() {
		mutex.lock();
	}
	
	public void unlock() {
		mutex.unlock();
	}
}
