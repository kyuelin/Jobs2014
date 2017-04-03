package dev.kyuelin.twos.subtree;

import java.util.*;

public class TreeDemo {
	public static void deleteSubTree(Node[] tree, int index) {
		tree[index].setVisited(true); 
		tree[index].setValid(false);
		
		for (int i = 0; i<tree.length; i++) {
			if(tree[i].getVisited()) 
				continue;
			if(checkForDeletion(tree, i)) 
				deleteTree(tree, i);
		}
		
	}
	
	public static boolean checkForDeletion(Node[] tree, int i) {
		while(tree[i].getParent()!= -1 && !tree[i].getVisited()) {
			tree[i].setVisited(true);
			i = tree[i].getParent();						
		}
		//if (tree[i].getParent() == -1) return false;
		return !tree[i].getValid();
	}
	
	public static void deleteTree(Node[] tree, int index) {
		while(tree[index].getValid()) {
			tree[index].setValid(false);
			index = tree[index].getParent();
		}
	}
	
	public static void deleteSubTree2(Node[] tree, int index) {

		tree[index].setValid(false);
		tree[index].setVisited(true);
		
		for(int i = 0; i < tree.length; i++) {
			Node n = tree[i];	
			if (n.getVisited() == false) {
				while (n.getParent() != -1 && n.getVisited() == false) {
					n = tree[n.getParent()];
				}
				if (n.getValid() == false) {
					deleteTree(tree, i); 
				}
			}
		}
	}
	
	public static void deleteSubTree3(Node[] tree, int index) {
		Map<Integer, ArrayList<Integer>> pmap = new HashMap<>();
		
		for(int j=0; j<tree.length; j++) {
			int p = tree[j].getParent();
			if (pmap.containsKey(p)) {
				pmap.get(p).add(j);
			}
			else {
				ArrayList<Integer> children = new ArrayList<Integer>();
				children.add(j);
				pmap.put(p, children);
			}
		}
		
		int del_node = index;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(del_node);
		while(!q.isEmpty()) {
			Integer n = q.poll();
			for (int k = 0; k < tree.length; k++) {
				if(tree[k].getParent() == n.intValue()) {
					q.offer(k);
				}
			}
			tree[n.intValue()].setValid(false);
		}
	}
	
	
	public static void main(String args[]) {
		int size = 11;
		Node[] tree = new Node[size];
		/*
		for(int i=0; i<size; i++) {
			tree[i] = new Node(-1, new Random().nextInt(100), true);
		}
		*/
		int i=0;
		tree[i++] = new Node(7, new Random().nextInt(100), true);
		tree[i++] = new Node(5, new Random().nextInt(100), true);
		tree[i++] = new Node(3, new Random().nextInt(100), true);
		tree[i++] = new Node(7, new Random().nextInt(100), true);
		tree[i++] = new Node(3, new Random().nextInt(100), true);
		tree[i++] = new Node(7, new Random().nextInt(100), true);
		tree[i++] = new Node(10, new Random().nextInt(100), true);
		tree[i++] = new Node(-1, new Random().nextInt(100), true);
		tree[i++] = new Node(5, new Random().nextInt(100), true);
		tree[i++] = new Node(4, new Random().nextInt(100), true);
		tree[i++] = new Node(8, new Random().nextInt(100), true);
		
		//Arrays.sort(tree, Node.NodePIndComparator);
		
		for(Node n: tree) {
			System.out.println(n.toString());
		}
		
		int index = 7;
		deleteSubTree(tree, index);
		//deleteSubTree2(tree, index);
		//deleteSubTree3(tree, index);

		
		
		System.out.println("----------------------");
		for(Node n: tree) {
			System.out.println(n.toString());
		}
	}
}
