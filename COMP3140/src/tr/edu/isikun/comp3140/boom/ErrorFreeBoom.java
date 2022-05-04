package tr.edu.isikun.comp3140.boom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tr.edu.isikun.comp3140.distributednetwork.CommunicationLink;
import tr.edu.isikun.comp3140.distributednetwork.Processor;

public class ErrorFreeBoom {
	private static List<Thread> allThreads;
	private static Processor[] processors;
	private static CommunicationLink[] links;

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new java.util.Scanner(System.in);
        int sizeOfRing = scanner.nextInt();
        scanner.close();
        createProcessors(sizeOfRing);
        createLinks(sizeOfRing);
        createAndRunThreads();
        int starter = (int) (Math.random() * sizeOfRing);
        processors[starter].wakeUp();
        joinThreads();
	}
	
	private static void createProcessors(int n) {
		processors = new Processor[n];
		for (int i=0; i < n; i++) {
		    processors[i] = new Processor(BoomGame.class);
		}
	}
	
	private static void createLinks(int n) {
		links = new CommunicationLink[n];
		for (int i=0; i<n; i++) {
			links[i] = new CommunicationLink(processors[i], processors[(i+1) % n]);
		}
	}

	private static void createAndRunThreads() {
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
	private static void joinThreads() throws InterruptedException {
		for (Thread t : allThreads) {
			t.join();
		}		
	}

}
