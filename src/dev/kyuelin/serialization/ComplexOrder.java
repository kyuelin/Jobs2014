package serialization;

public class ComplexOrder extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	int doSomething() {
		System.out.println("Do complicated stuff.");
		return 0;
	}

}
