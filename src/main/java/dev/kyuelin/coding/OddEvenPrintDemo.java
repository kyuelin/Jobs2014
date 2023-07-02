package dev.kyuelin.coding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPrintDemo {

	private static final Logger logger = LoggerFactory
			.getLogger(OddEvenPrintDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		class CountThread implements Runnable {

			private final int remain;
			private final AtomicInteger count;

			CountThread(AtomicInteger c, int rem) {
				count = c;
				remain = rem;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
					while (count.get() < 9) {
						synchronized(count) {
							if (count.get() % 2 != remain) {	
								count.incrementAndGet();
								logger.debug("count=" + count.toString());
							}							
						}
					}					
					logger.debug("done...");
			}

		}

		AtomicInteger count = new AtomicInteger(0);		
		new Thread(new CountThread(count, 0)).start();
		new Thread(new CountThread(count, 1)).start();
	}

}
