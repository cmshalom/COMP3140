package tr.edu.isikun.comp3140.distributednetwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class CommunicationNetwork {
	private List<Thread> allThreads;
	private Processor[] processors;
	private Collection<CommunicationLink> links;

	public CommunicationNetwork(Scanner scanner, Class<? extends Algorithm> cls) throws InterruptedException {
		createNetworkFromInput(scanner, cls);
        createAndRunThreads();
	}

	private void createNetworkFromInput(Scanner scanner, Class<? extends Algorithm> cls) {
        int numberOfProcessors = scanner.nextInt();
        createProcessors(numberOfProcessors, cls);
        createLinks(scanner);
	}
	
	private void createProcessors(int n, Class<? extends Algorithm> cls) {
		processors = new Processor[n];
		for (int i=0; i < n; i++) {
		    processors[i] = new Processor(i, cls);
		}
	}
	
	private void createLinks(Scanner scanner) {
		links = new ArrayList<>();
		int from, to;
        do {
        	from = scanner.nextInt();
        	to = scanner.nextInt();
        	if (from >= 0 && to >= 0) {
    			links.add(new CommunicationLink(processors[from], processors[to]));        		
    			links.add(new CommunicationLink(processors[to], processors[from]));        		
        	}
        } while (from >= 0 && to >= 0);
	}

	private void createAndRunThreads() {
		allThreads = new ArrayList<>();
		for (Processor p : processors) {
			allThreads.add(new Thread(p));
		}
		for (CommunicationLink l : links) {
			allThreads.add(new Thread(l));
		}
		for (Thread t : allThreads) {
			t.start();
		}
	}
	
	public void wakeUpStarters(Scanner scanner) {
		int starter;
        do {
        	starter = scanner.nextInt();
        	if (starter >= 0) {
        	    processors[starter].wakeUp();
        	}
        } while (starter >= 0);
	}
	
	public void joinThreads() throws InterruptedException {
		for (Thread t : allThreads) {
			t.join();
		}		
	}

}
