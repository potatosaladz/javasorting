package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * Heapsort is an efficient selection-based algorithm. First, we build a heap
 * from the bottom up, in-place. Next, we repeatedly remove the largest element in the heap.
 * 
 * @author Nicolas Garnil
 * 
 */

public abstract class AbstractHeapSorter extends AbstractSorter {

	protected AbstractHeapSorter(SorterType type) {
		super(type);
	}

	public <T> void sort(Comparator<T> comparator, List<T> list) {
		sort(comparator, list, list.size() - 1);
	}

	private <T> void sort(Comparator<T> comparator, List<T> list, int n) {
		for (int k = n / 2; k >= 0; k--) {
			sink(comparator, list, k, n);
		}
		while (n >= 0) {
			swap(list, 0, n);
			sink(comparator, list, 0, --n);
		}
	}

	protected abstract <T> void sink(Comparator<T> comparator, List<T> list, int k, int n);
}
