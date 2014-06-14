package dev.kyuelin.logging;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerCallable implements Callable<Object> {

	private static Logger logger = LoggerFactory.getLogger(LoggerCallable.class);

	private int loop = 1;
	
	public LoggerCallable(int l) {
		loop=l; 
	}
	
	public void run() {
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		int i = loop;
		while (i>0) {
			logger.debug(i-- + ":debugging abcdefghijklmnopqstuvwxyz1234567890");
		}
		return null;
	}

}
