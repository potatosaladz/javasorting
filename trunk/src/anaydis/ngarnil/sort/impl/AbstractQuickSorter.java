package anaydis.ngarnil.sort.impl;

import java.util.Comparator;

/**
 * Base class for QuickSort implementations. 
 * 
 * @author Nicolas Garnil
 * 
 */

import java.util.List;

import anaydis.ngarnil.sort.SorterType;

public abstract class AbstractQuickSorter extends AbstractSorter {

	protected AbstractQuickSorter(SorterType type) {
		super(type);
	}

	@Override
	public abstract <T> void sort(Comparator<T> comparator, List<T> list);

	protected <T> int partition(Comparator<T> comparator, List<T> list, int l, int r) {

		int i = l - 1;
		int j = r;
		for (;;) {
			while (greater(comparator, list, r, ++i)) {
				if (i == r) {
					break;
				}
			}
			while (greater(comparator, list, --j, r)) {
				if (j == l) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			swap(list, i, j);
		}

		swap(list, i, r);
		return i;
	}

}
