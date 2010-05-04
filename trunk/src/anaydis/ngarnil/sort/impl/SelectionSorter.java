package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * One of the simplest sorting algorithms works as follows: First, find the
 * smallest element in the array, and exchange it with the element in the first
 * position. Then, find the second smallest element and exchange it with the
 * element in the second position. Continue in this way until the entire array
 * is sorted. This method is called selection sort because it works by
 * repeatedly selecting the smallest remaining element.
 * 
 * @author Nicolas Garnil
 */

public class SelectionSorter extends AbstractSorter {

	public SelectionSorter() {
		super(SorterType.SELECTION);
	}

	/**
	 * 
	 * Sorts a list of given elements using Selection Sort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the list to be sorted
	 */

	@Override
	public <T> void sort(Comparator<T> comparator, List<T> list) {
		int n = list.size();
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (greater(comparator, list, min, j)) {
					min = j;
				}
			}
			swap(list, i, min);
		}
	}
}
