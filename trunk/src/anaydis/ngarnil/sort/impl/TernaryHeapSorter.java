package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * Three-child implementation of HeapSort.
 * 
 * @author Nicolas Garnil
 *
 */
public class TernaryHeapSorter extends AbstractHeapSorter {
	
	public TernaryHeapSorter() {
		super(SorterType.HEAP_TERNARY);
	}

	protected <T> void sink(Comparator<T> comparator, List<T> list, int k, int N) {
		while (3 * k + 1 <= N) {
			int j = 3 * k + 1;
			if (j + 2 < N) {
				j = max(comparator, list, j, j + 1, j + 2);
			} else {
				if (j + 1 < N) {
					if (greater(comparator, list, j + 1, j)) {
						j++;
					}
				}
			}
			if (greater(comparator, list, k, j)) {
				break;
			}
			swap(list, k, j);
			k = j;
		}
	}

	private <T> int max(Comparator<T> c, List<T> list, int a, int b, int d) {
		if (greater(c, list, a, b) && greater(c, list, a, d)) {
			return a;
		} else {
			if (greater(c, list, b, d)) {
				return b;
			} else {
				return d;
			}
		}
	}
}
