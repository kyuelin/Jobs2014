package dev.kyuelin.twos.subtree;

import java.util.Comparator;

class Node implements Comparable<Node>{
	private int parent;
	private int value;
	private boolean valid=true;
	private boolean visited=false;
	
	private Node(int p, int u, boolean v, boolean vs) {
		this.parent=p;
		this.value=u;
		this.valid=v;
		this.visited=vs;
	}
	
	Node(int p, int u, boolean v) {
		this(p,u,v,false);
	}

	int getParent() {
		return parent;
	}
	
	boolean getValid() {
		return valid;
	}
	
	void setValid(boolean v) {
		this.valid=v;
	}
	
	void setVisited(boolean v) {
		this.visited=v;
	}
	
	boolean getVisited() {
		return this.visited;
	}
	
	public String toString() {
		return new String(this.parent + ":" + this.value + ":" + this.valid);
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.parent-o.parent;
	}
	
	public static Comparator<Node> NodePIndComparator  = new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.parent-o2.parent;
		}
		
	};
}
