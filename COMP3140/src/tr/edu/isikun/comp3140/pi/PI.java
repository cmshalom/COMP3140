package tr.edu.isikun.comp3140.pi;

import tr.edu.isikun.comp3140.distributednetwork.Algorithm;
import tr.edu.isikun.comp3140.distributednetwork.CommunicationLink;
import tr.edu.isikun.comp3140.distributednetwork.Message;
import tr.edu.isikun.comp3140.distributednetwork.Processor;

public class PI implements Algorithm {
	private Processor processor;
	private Processor parent;
	private boolean done = false;

	public PI(Processor processor) {
		assert(processor != null);
		this.processor = processor;		
	}
	
	@Override
	public void onWakeUp() {
		done = true;
		System.out.println("ROOT:" + processor.getId());
		for (CommunicationLink l : processor.getOutgoingLinks()) {
			l.send(new PIMessage(processor));
		}
	}
	
	@Override
	public void onMessage(Message<?> message) {
		if (done) return;
		done = true;
		parent = message.getSource();
		System.out.println(processor.getId() + "->" + parent.getId());
		for (CommunicationLink l : processor.getOutgoingLinks()) {
			if (l.getDestination() != parent) {
				l.send(new PIMessage(processor));							
			}
		}
	}

}
