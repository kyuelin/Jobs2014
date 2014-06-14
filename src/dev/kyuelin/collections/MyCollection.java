package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MyCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	ArrayList<Integer> grades = new ArrayList<Integer>(123);
		//testIterator();
		testHashMap();
		//testShift();
		//testNLog();
		//testSycMap();
	}

	private static void testSycMap() {
		// TODO Auto-generated method stub
		Map<Integer, String> mapIS = new ConcurrentHashMap<Integer, String>();
		mapIS.put(12, "twelve");
	}

	@SuppressWarnings("unused")
	private static <E> void testIterator() {
		// TODO Auto-generated method stub
		List<Integer> cars = new ArrayList<Integer>();
		
		for (int i=0; i<20; i++) {
			cars.add(i);
		}
		
		Iterator<Integer> it = cars.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

	private static void testHashMap() {
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		System.out.println(myMap.put(null, "a"));
		System.out.println(myMap.put(null, "b"));
		
		System.out.println(myMap.get(null));
		System.out.println(myMap.get(2));		
		System.out.println(myMap.get(3));		
	}
	
	@SuppressWarnings("unused")
	private static void testNLog() {
		// TODO Auto-generated method stub
		System.out.println(Math.E);
		
	}

	@SuppressWarnings("unused")
	private static void testShift() {
		// TODO Auto-generated method stub
		int i=0xffffffff;
		printInt(i);
		i=0x7fffffff;
		printInt(i);
		i = i << 1;
		printInt(i);
		i = i >>> 1;
		i = i >> 1;
		printInt(i);
		i = i >>> 1;
		printInt(i);			
	}

	public Vector<String> getMyV() {
		return myV;
	}

	private final Vector<String> myV = new Vector<String>();
	
	public static void printInt (int i) {
		System.out.println("i="+ i);	
		System.out.println(Integer.toBinaryString(i));		
	}
	
	class MyComp<T> implements Comparator<T> {
		@Override
		public int compare(T o1, T o2) {
			// TODO Auto-generated method stub
			return 0;
		}		
	}
}
