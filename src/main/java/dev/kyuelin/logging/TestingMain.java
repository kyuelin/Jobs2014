package dev.kyuelin.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class TestingMain {

	private static Logger logger = LoggerFactory.getLogger(LoggerRunnable.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		System.out.println("Test started @ " +  time);
		
		TestInterface test = null;
		//Runnable task = new LoggerRunnable();
		//test = new SingleThreadTest();
		//((SingleThreadTest) test).setTask(task);

		//final int numThread = 32;	// bottleneck, e.g. DB connection
		//final int numObject = 32; 	// number of classes using logger
		final int numThread = 250;
		final int numObject = numThread;	
		final int numLoop   = 100;  	// write 500 lines
		
		int numObj = numObject;
		
		Collection<Callable<Object>> alltasks = new ArrayList<>();

		while (numObj-- > 0) {
			alltasks.add(new LoggerCallable(numLoop));
		}
		test = new MultiThreadTest<Object>(numThread);
		((MultiThreadTest<Object>)test).setTasks(alltasks);
		
		test.execute();		
		System.out.println("Test completed @ " + numThread + "," + numObject + "," + numLoop + "," +  (System.currentTimeMillis()-time) + " ms");
	}

}
