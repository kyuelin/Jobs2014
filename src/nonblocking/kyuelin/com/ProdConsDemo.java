package nonblocking.kyuelin.com;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdConsDemo {

	private final int BOUND = 10;
	private final int SLEEP_C = 100;
	private final int SLEEP_P = 100;

	private static final Logger logger  = LoggerFactory.getLogger(ProdConsDemo.class);
		
	public void testLinkedBlockingQueue() {
		BlockingQueue<Double> queue = new LinkedBlockingQueue<Double>();
		new Thread(new ProducerBQ(queue)).start();
		new Thread(new ConsumerBQ(queue)).start();		
	}
	
	
	public void testConcurrentLinkedQueue() {
		Queue<Double> queue = new ConcurrentLinkedQueue<Double>();
		new Thread(new ProducerCLQ(queue)).start();
		new Thread(new ConsumerCLQ(queue)).start();		
	}

	public void testWaitNotifyImpl() {
		Queue<Double> queue = new LinkedList<Double>();
		new Thread(new ProducerWN(queue)).start();
		//new Thread(new ProducerWN(queue)).start();
		new Thread(new ConsumerWN(queue)).start();
	}
	
	public void testObserverImpl() {
		ProducerOB prod = new ProducerOB();
		prod.addObserver(new ConsumerOB());		
		new Thread(prod).start();
		new Thread(prod).start();
		new Thread(prod).start();
		new Thread(prod).start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new ProdConsDemo().testWaitNotifyImpl();
		//new ProdConsDemo().testLinkedBlockingQueue();
		//new ProdConsDemo().testConcurrentLinkedQueue();
		new ProdConsDemo().testObserverImpl();
	}

	
	/*
	 * Queue Consumer
	 */
	public class ConsumerCLQ implements Runnable {

		private final Queue<Double> queue;

		public ConsumerCLQ(Queue<Double> q) {
			this.queue = q;
		}

		@Override
		public void run() {
			try {
				while (true) {
					Double d = queue.poll();
					if (d != null) {
						logger.debug(this.getClass().getName()+"("+queue.size()+")..." + d.toString());
					}
					Thread.sleep(SLEEP_C);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	/*
	 * Queue Producer
	 */
	public class ProducerCLQ implements Runnable{
		
		private final Queue<Double> queue;
		
		public ProducerCLQ(Queue<Double> q) {
			this.queue=q;
		}

		@Override
		public void run() {
			while(true) {
				try {
					Double d = new Double(Math.random()); 
					queue.add(d);
					logger.debug(this.getClass().getName()+"("+queue.size()+")..." + d.toString());
					Thread.sleep(SLEEP_P);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	/*
	 * BlockingQueue Consumer
	 */
	public class ConsumerBQ implements Runnable {

		private final BlockingQueue<Double> queue;

		public ConsumerBQ(BlockingQueue<Double> q) {
			this.queue = q;
		}

		@Override
		public void run() {
			try {
				while (true) {
					Double d = queue.take();
					logger.debug(this.getClass().getName()+"("+queue.size()+")..." + d.toString());
					Thread.sleep(SLEEP_C);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*
	 * BlockingQueue Producer
	 */
	public class ProducerBQ implements Runnable{
		
		private final BlockingQueue<Double> queue;
		
		public ProducerBQ(BlockingQueue<Double> q) {
			this.queue=q;
		}

		@Override
		public void run() {
			while(true) {
				try {
					Double d = new Double(Math.random()); 
					queue.add(d);
					queue.put(d);
					logger.debug(this.getClass().getName()+"("+queue.size()+")..." + d.toString());
					Thread.sleep(SLEEP_P);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}		
	}

	/*
	 * Wait-Notify Producer
	 */
	public class ProducerWN implements Runnable {

		private final Queue<Double> queue;
		
		public ProducerWN(Queue<Double> q) {
			this.queue=q;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				synchronized (queue) {
					while (queue.size()==BOUND) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Double d = new Double(Math.random()); 
					queue.add(d);
					logger.debug(this.getClass().getName()+"("+queue.size()+")..." + d.toString());
					queue.notify();
				}
				try {
					Thread.sleep(SLEEP_P);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}				
		}
	}
	
	/*
	 * Wait-Notify Consumer 
	 */
	public class ConsumerWN implements Runnable {
		
		private final Queue<Double> queue;
		
		public ConsumerWN(Queue<Double> q) {
			this.queue=q;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Double d = queue.poll();	
					logger.debug(this.getClass().getName()+"("+queue.size()+")..." + d.toString());
					queue.notify();
				}
				try {
					Thread.sleep(SLEEP_C);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * Observer Producer
	 */
	public class ProducerOB extends Observable implements Runnable {
		
		@Override
		public void run() {
			while(true) {				
				Double d = new Double(Math.random());
				logger.debug(this.getClass().getName()+"..." + d.toString());
				this.setChanged();
				this.notifyObservers(d);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/* 
	 * Observer Consumer
	 */
	public class ConsumerOB implements Observer {
		@Override
		public void update(Observable o, Object arg) {
			Double d = (Double) arg;
			logger.debug(this.getClass().getName()+"..." + d.toString());
		}		
	}	
}
