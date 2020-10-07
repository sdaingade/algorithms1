package algos.impl;

import algos.iface.MaxPQ;
import algos.util.SortingUtils;

public class UnorderedMaxPQ<T extends Comparable<T>> implements MaxPQ<T> {

	private T[] _pq = null;
	private int _index = 0;
	
	public UnorderedMaxPQ(int size) {
		_pq = (T[]) new Object[size];
	}

	public void insert(T item) throws Exception {
		if (_index >= _pq.length)
			throw new Exception("Priority Queue is full");

		_pq[_index] = item;
		_index++;
	}

	public T deleteMax() throws Exception {
		if (isEmpty())
			throw new Exception("Priority Queue is empty");
		
		int max = 0;
		for (int i=0; i<_index; i++) {
			if (SortingUtils.less(_pq[max], _pq[i]))
				max = i;
		}
		SortingUtils.exch(_pq, max, _index - 1);
		T item  = _pq[_index - 1];
		_pq[_index - 1] = null;
		_index--;

		return item; 
	}
	
	public boolean isEmpty() {
		return _index <= 0;
	}
}