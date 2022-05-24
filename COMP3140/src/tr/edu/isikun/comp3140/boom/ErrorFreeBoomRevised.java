package tr.edu.isikun.comp3140.boom;

import java.util.Scanner;

import tr.edu.isikun.comp3140.distributednetwork.CommunicationNetwork;

public class ErrorFreeBoomRevised {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        CommunicationNetwork network = new CommunicationNetwork(n, BoomGame.class);
		for (int i=0; i<n; i++) {
			network.createLink(i, (i+1) %n);
		}
        network.runThreads();
        network.wakeUpStarter((int) (Math.random() * n));
        network.joinThreads();
	}
	
}
