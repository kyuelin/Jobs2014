package dev.kyuelin.serialization;

public class SimpleOrder extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489788052066168482L;

	@Override
	int doSomething() {
		System.out.println("Do simple stuff.");
		return 0;
	}

}
