package tr.edu.isikun.comp3140.pi;

import tr.edu.isikun.comp3140.distributednetwork.Message;
import tr.edu.isikun.comp3140.distributednetwork.Processor;

public class PIMessage extends Message<PI> {

	public PIMessage(Processor from) {
		super(from);
	}

}
