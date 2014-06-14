package dev.kyuelin.algorithms;


public class QUAlgorithm implements IQAlgorithm {
	
	private int[] id;
	
	public QUAlgorithm(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		for (int i=0; i<N; i++) {
			id[i] = i;
		}
	}

	public int root(int pid) {
		while (pid!=id[pid]) {
			pid=id[pid];
		}
		return pid;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i]=j;
	}
}
