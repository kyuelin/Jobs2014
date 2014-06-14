package patterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternsTest {

	private static final Logger logger  = LoggerFactory.getLogger(PatternsTest.class);
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SingletonEager single = SingletonEager.getInstance();

		class SingleThread implements Runnable {
			public void run() {
				while (true) {
					single.id="single";
					//logger.debug(this.getClass().getName() + "..." + single.id);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}									
				}
			}
		}
		
		class SecondThread implements Runnable {
			public void run() {
				while (true) {
					single.id="second";
					//logger.debug(this.getClass().getName() + "..." + single.id);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}		
		
		class ReadThread implements Runnable {
			public void run() {
				while (true) {
					logger.debug(this.getClass().getName() + "..." + single.id);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}		
		new Thread(new SecondThread()).start();
		new Thread(new SingleThread()).start();
		new Thread(new ReadThread()).start();

	}

}
