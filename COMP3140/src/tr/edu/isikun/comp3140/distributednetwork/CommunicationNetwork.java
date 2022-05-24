package tr.edu.isikun.comp3140.distributednetwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CommunicationNetwork {
	protected List<Processor> processors = new ArrayList<>();
	protected Collection<CommunicationLink> links = new ArrayList<>();
	private List<Thread> allThreads = new ArrayList<>();

	public CommunicationNetwork(int n, Class<? extends Algorithm> cls) {
		for (int i=0; i < n; i++) {
		    addProcessor(i, cls);
		}
	}

	public void addProcessor(int id, Class<? extends Algorithm> cls) {
	    Processor p = new Processor(id, cls);
	    processors.add(p);
		allThreads.add(new Thread(p));
	}

	public void createLink(int from, int to) {
		assert(from >= 0 && to >= 0);
		assert(from <= processors.size() && to <= processors.size());
		CommunicationLink l = new CommunicationLink(processors.get(from), processors.get(to)); 
		links.add(l);        		
		allThreads.add(new Thread(l));
	}
		
	public void createBidirectionalLink(int from, int to) {
		createLink(from, to);
		createLink(to, from);
	}
	
	public void createBidirectionalLinks(Scanner scanner) {
		int from, to;
		while(true) {
		    from = scanner.nextInt();
		    to = scanner.nextInt();
			if (from < 0 || to < 0) return;
			createBidirectionalLink(from, to);
		}
	}

	public void runThreads() {
		for (Thread t : allThreads) {
			t.start();
		}
	}
	
	public void wakeUpStarter(int starter) {
		processors.get(starter).wakeUp();
	}

	public void wakeUpStarters(Stream<Integer> starters) {
		starters.forEach(s -> wakeUpStarter(s));
	}

	public void wakeUpStarters(Scanner scanner) {
		int s;
		while(true) {
		    s = scanner.nextInt();
			if (s < 0) return;
			wakeUpStarter(s);
		}
	}
	
	public void joinThreads() throws InterruptedException {
		for (Thread t : allThreads) {
			t.join();
		}		
	}

}
