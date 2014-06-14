package patterns;

public class SingletonLazy {
	private static volatile SingletonLazy single = null;
	private SingletonLazy() {}
	public static SingletonLazy getInstance() {
		if (single == null) {
			synchronized (SingletonLazy.class) {
				if (single == null) { single = new SingletonLazy();}
			}
		}
		return single;
	}
}
