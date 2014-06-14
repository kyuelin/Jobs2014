package dev.kyuelin.concurrency;

public class StartThreadDemo {
	
	public static void main(String [] args) {
		Thread startT = new Thread(new Task("starter"));
		Thread runT = new Thread(new Task("runner"));
		
		startT.start();
		runT.run();
	}
	
	private static class Task implements Runnable {
		private String caller;
		
		public Task(String name) {
			this.caller=name;
		}
		
		public void run() {
			System.out.println("caller:"+caller+" in thread"+Thread.currentThread().getName());
		}
		
	}

}
