package dev.kyuelin.patterns;

public class AbstractFactory {
	public IFactory makeFactory(int type) {
		switch (type) {
		case 1:
			return new FactoryOne();
		case 2:
			return new FactoryTwo();	
		default:				
			return null;
		}
	}
	public interface IFactory {
		IProduct produce();
	}	
	public interface IProduct {
		void doSomething();
	}
	public class FactoryOne implements IFactory {
		public IProduct produce() {return new ProductOne();}		
	}
	public class FactoryTwo implements IFactory {
		public IProduct produce() {return new ProductTwo();}		
	}
	public class ProductOne implements IProduct {
		public void doSomething() {
        }
	}
	public class ProductTwo implements IProduct {
		public void doSomething() {
        }
	}
	
	public static void main(String[] args) {
		new AbstractFactory().makeFactory(1).produce().doSomething();
	}
}
