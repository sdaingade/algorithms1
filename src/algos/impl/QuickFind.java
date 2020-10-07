package algos.impl;

import algos.iface.UnionFind;

public class QuickFind implements UnionFind {
	
	private int[] _id;

	public QuickFind(int n) {
		_id = new int[n];
		
		for (int i = 0; i < n; i++)
			_id[i] = i;
	}
	
	@Override
	public void union(int p, int q) {
		int pid = _id[p];
		for (int i = 0; i < _id.length; i++) {
			if(_id[i] == pid)
				_id[i] = _id[q];
		}
		
	}

	@Override
	public boolean connected(int p, int q) {
		return _id[p] == _id[q];
	}

	@Override
	public int find(int p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}