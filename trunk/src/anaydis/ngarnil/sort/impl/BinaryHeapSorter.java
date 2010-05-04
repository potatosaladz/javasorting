package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

public class BinaryHeapSorter extends AbstractHeapSorter {

	public BinaryHeapSorter() {
		super(SorterType.HEAP_BINARY);
	}

	protected <T> void sink(Comparator<T> comparator, List<T> list, int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(comparator, list, j, j + 1))
				j++;
			if (!less(comparator, list, k, j))
				break;
			swap(list, k, j);
			k = j;
		}
	}
}
