package concurrency;

public class WaitDemo {
	
	private static Object monitor = new Object();
	private static boolean isProcessed = false;
	
	public static void main (String [] args) {
		
		new ThreadOne().start();
		new ThreadTwo().start();
	}

	private static class ThreadOne extends Thread{
		public void run() {
			while(!isProcessed) {
				System.out.println("Not Processed...");
				synchronized (monitor) {					
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("Processed...");
		}
	}
	
	private static class ThreadTwo extends Thread {
		public void run() {
			System.out.println("processing...");
			isProcessed=true;
			synchronized (monitor) {
				monitor.notifyAll();				
			}
		}
	}

}
