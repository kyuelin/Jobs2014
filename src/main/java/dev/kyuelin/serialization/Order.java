package dev.kyuelin.serialization;

import java.io.Serializable;

public abstract class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int oid;
	
	abstract int doSomething();
		
}
