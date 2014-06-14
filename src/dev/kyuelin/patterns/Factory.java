package patterns;

public class Factory {
	public IProduct createProduct(int prodType) {
		switch (prodType) {
		case 1:
			return new ProductOne();
		case 2:
			return new ProductTwo();
		default:
			return null;
		}
	}	
	public interface IProduct {
		public void doSomething();
	}	
	public class ProductOne implements IProduct {
		public void doSomething() {}
	}
	
	public class ProductTwo implements IProduct {
		public void doSomething() {}
	}
}
