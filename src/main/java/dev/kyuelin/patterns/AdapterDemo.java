package dev.kyuelin.patterns;

public class AdapterDemo {
	
	public class Adaptee {
		public void method1() {}		
	}	
	public class Adapter {		
		private Adaptee a = null;
		public void injAdapter(Adaptee adp) {
			a = adp;
		}
		public void method() {
			a.method1();
		}				
	}
	
	
	interface Adaptee1 {
		public void method1();
	}	
	interface Adaptee2 {
		public void method2();
	}
	class Adapter2 implements Adaptee1, Adaptee2 {
		public void method() {
			method1();
			method2();
		}
		public void method2() {}
		public void method1() {}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
