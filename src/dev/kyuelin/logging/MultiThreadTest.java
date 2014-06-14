package com.ms.linken.logging;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadTest<T> implements TestInterface {

	private int nThread = 1;
	private Collection<Callable<Object>> tasks;

	public MultiThreadTest(int n) {
		nThread=n;		
	}
	
	public MultiThreadTest() {}
	
	public void setTasks(Collection<Callable<Object>> t) {
		tasks = t;
	}
	
	public void setNThread (int n) {
		nThread=n;
	}

	@Override
	public void execute() {
		
		ExecutorService executor = Executors.newFixedThreadPool(nThread);
		try {
			List<Future<Object>> results = executor
					.invokeAll((Collection<? extends Callable<Object>>) tasks);
			for (Future<Object> result : results) {
				result.get();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
