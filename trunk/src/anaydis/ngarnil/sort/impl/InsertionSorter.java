package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * The method that people often use to sort bridge hands is to consider the
 * cards one at a time, inserting each into its proper place among those already
 * considered (keeping them sorted). In a computer implementation, we need to
 * make space for the element being inserted by moving larger elements one
 * position to the right, and then inserting the element into the vacated
 * position.
 * 
 * @author Nicolas Garnil
 * 
 */

public class InsertionSorter extends AbstractSorter {

	public InsertionSorter() {
		super(SorterType.INSERTION);
	}

	/**
	 * 
	 * Sorts a list of given elements using Insertion Sort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the list to be sorted
	 */

	@Override
	public <T> void sort(Comparator<T> comparator, List<T> list) {
		sort(comparator, list, 0, list.size());
	}

	public <T> void sort(Comparator<T> comparator, List<T> list, int l, int r) {
		for (int i = l; i < r; i++) {
			for (int j = i; j > l; j--) {
				if (greater(comparator, list, j - 1, j)) {
					swap(list, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
}
