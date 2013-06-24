import java.util.Random;

class Visitor extends Thread {
	public int id;
	Random numGen = new Random();
	
	public Visitor(int i) {
		this.id = i;
	}

	public void run() {
		getCar();
		Monitor.shut(1);
		releaseCar();

	}

	public synchronized void releaseCar() {
		if (Monitor.availableCars <= 5) {
			Monitor.availableCars++;
			System.out
					.println("Car released...available cars=" + Monitor.availableCars);
			notifyAll();
		}
	}

	public synchronized void getCar() {
		Monitor.availableCars--;

		if (Monitor.availableCars == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(id + "...took a car. available cars ="
				+ Monitor.availableCars);
	}
}

// Main Class
public class Monitor {
	public static int availableCars=5;

	public static void shut(int r) {
		try {
			Thread.sleep(r * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("This is a monitor test:" + availableCars);
		int numVisitors = 10;
		for (int i = 0; i < numVisitors; i++) {
			shut(1);
			Visitor newVisitor = new Visitor(i);
			newVisitor.start();
		}
	}
}