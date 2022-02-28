package dev.kyuelin.twos.queuecomp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Demo {
	public static void main(String[] args) {
		Integer[] ip = new Integer[100];
		
		int i=0;
		while (i<13) {
			ip[i] = i++;
		}
		
		MyCollection<Integer> mycol = new MyCollection<Integer>(ip);
		for(Integer it: mycol) {
			System.out.println(it);
		}
		
	}
	
	public static void swapQueue() {
		Queue<Integer> q1 = new LinkedList();
		Queue<Integer> q2 = new LinkedList();
		Queue q3;
		
		int i=10;
		while (i>0) {
	 		q1.add(i--);			
		}
		while(i >0 ) {
			q2.add(i--);			
		}
		
		System.out.println(q1.size() + ":" + q2.size() );
		
		q3 = q2; q2=q1; q1=q3;
		System.out.println(q1.size() + ":" + q2.size() );
	}
	
	public static class MyCollection<Integer> implements Iterable<Integer> {
		
		private final Integer[] arrInt;
		private final int size;

		public MyCollection(Integer[] irr) {
			this.arrInt=irr;
			this.size = irr.length;
		}
		
		@Override
		public Iterator<Integer> iterator() {
			// TODO Auto-generated method stub
			Iterator<Integer> it = new Iterator<Integer>() {

				private int current = 0;
				
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return current < size && arrInt[current] != null;
				}

				@Override
				public Integer next() {
					// TODO Auto-generated method stub
					return arrInt[current++];			
				}
				
				@Override
				public void remove() {
					
				}
				
			};
			return it;
		}
	}
}
