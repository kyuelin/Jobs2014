package dev.kyuelin.concurrency;


public class DeadLockDemo {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Object o1 = new Object();
		final Object o2 = new Object();		
		Thread t1 = new Thread() {
			public void run() {
				synchronized(o1) {
					System.out.println("T1/O1");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(o2) {
						System.out.println("T1/O2");
					}
				}
			}
		};		
		Thread t2 = new Thread() {
			public void run() {
				synchronized(o2) {
					System.out.println("T2/O2");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(o1) {
						System.out.println("T2/O1");
					}
				}
			}
		};	
		t1.start();
		t2.start();
	}
}
