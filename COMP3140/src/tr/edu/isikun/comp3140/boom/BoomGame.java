package tr.edu.isikun.comp3140.boom;

import tr.edu.isikun.comp3140.distributednetwork.Algorithm;
import tr.edu.isikun.comp3140.distributednetwork.Message;
import tr.edu.isikun.comp3140.distributednetwork.Processor;

public class BoomGame implements Algorithm {
	private Processor processor;

	public BoomGame(Processor processor) {
		assert(processor != null);
		this.processor = processor;		
	}
	
	@Override
	public void onWakeUp() {
		sendNumber(1);
	}
	
	@Override
	public void onMessage(Message<?> message) {
		sendNumber(((BoomGameMessage)message).getNumber()+1);
	}

	private static boolean isBoom(int i) {
		return i % 3 == 0 || i % 5 == 0;
	}
	
	private void sendNumber(int i) {
		System.out.println(isBoom(i) ? "BOOM" : i);
		processor.getFirstOutgoingLink().send(new BoomGameMessage(processor, i));
	}

}
