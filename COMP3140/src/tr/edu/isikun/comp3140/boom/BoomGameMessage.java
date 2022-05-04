package tr.edu.isikun.comp3140.boom;

import tr.edu.isikun.comp3140.distributednetwork.Message;
import tr.edu.isikun.comp3140.distributednetwork.Processor;

public class BoomGameMessage extends Message<BoomGame> {
	private int number;

	public BoomGameMessage(Processor from, int number) {
		super(from);
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

}
