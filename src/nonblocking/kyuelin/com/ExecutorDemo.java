package nonblocking.kyuelin.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ExecutorDemo {

	private final int nThreads = 100;	
	private final ExecutorService executor = Executors.newFixedThreadPool(nThreads);	
	private final List<IntCount> counters;
	
	private static final Logger logger  = LoggerFactory.getLogger(ExecutorDemo.class);
	
	public ExecutorDemo(int number) {		
		counters = new ArrayList<ExecutorDemo.IntCount>();
		while (--number > 0) {
			counters.add(new IntCount(number));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExecutorDemo(1000).runTest();		
	}
	
	public void runTest() {

		CompletionService<Integer> comService = new ExecutorCompletionService<Integer>(executor);

		for(final IntCount count : counters) {
			comService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					return count.count100();
				}
			});
		}
		
		for(final IntCount count : counters) {
			try {
				Future<Integer> f = comService.take();
				Integer i = f.get();				
				logger.debug("ExecutorDemo -- get -- " + i.toString());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	public class IntCount {
		private Integer count;
		
		public IntCount(int i) {
			count = new Integer(i);
		}
		
		public Integer count100() {
			int i=100;
			while(i-->0) {
				++count;
			}
			
			logger.debug("IntCount::count100() -- return -- " + count);
			return count;
		}
		
		
	}
	
	public class CRun<V> implements Runnable {
		
		FutureTask<V> task;
		
		public CRun(FutureTask<V> t) {
			task=t;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				task.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}