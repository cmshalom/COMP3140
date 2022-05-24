package tr.edu.isikun.comp3140.pi;

import java.util.Scanner;

import tr.edu.isikun.comp3140.distributednetwork.CommunicationNetwork;

public class PIMain {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		CommunicationNetwork network = new CommunicationNetwork(n, PI.class);
		network.createBidirectionalLinks(scanner);
		network.wakeUpStarters(scanner);
		scanner.close();
		network.joinThreads();
	}

}
