package anaydis.ngarnil.sort.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * Base class for MergeSort implementations. 
 * 
 * @author Nicolas Garnil
 * 
 */

public abstract class AbstractMergeSorter extends AbstractSorter {

	protected AbstractMergeSorter(SorterType type) {
		super(type);
	}

	public abstract <T> void sort(Comparator<T> comparator, List<T> list);

	public <T> void merge(Comparator<T> comparator, List<T> list, int l, int m, int r) {
		final List<T> aux = new ArrayList<T>();
		int i;
		int j;
		for (i = 0; i < m + 1; i++) {
			copy(list, aux, i, i, true);
		}
		for (j = r; j >= m + 1; j--) {
			copy(list, aux, j, j, true);
		}
		i = l;
		j = r;
		for (int k = l; k <= r; k++) {
			if (less(comparator, aux, j, i)) {
				copy(aux, list, j--, k, false);
			} else {
				copy(aux, list, i++, k, false);
			}
		}
	}
}
