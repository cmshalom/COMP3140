package tr.edu.isikun.comp3140.distributednetwork;

public interface Algorithm {
	public void onWakeUp();
	public void onMessage(Message<?> message);
}
