package patterns;

public class SingletonEager {
	
	private static final SingletonEager single = new SingletonEager("default");
	
	public String id; 
	
	private SingletonEager(String i) {
		this.id=i;
	}
	
	public static SingletonEager getInstance() { return single;}

}
