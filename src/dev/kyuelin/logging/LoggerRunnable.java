package com.ms.linken.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerRunnable implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(LoggerRunnable.class);

	@Override
	public void run() {
		int i = 0;
		while (i++ < 500) {
			logger.debug(i + ":debugging abcdefghijklmnopqstuvwxyz1234567890");
		}
	}

}
