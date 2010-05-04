package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

public class QuickMedianOfThreeSorter extends AbstractQuickCutSorter {

	/**
	 * Another improvement to quicksort is to use a partitioning element that is
	 * more likely to divide the file near the middle. There are several
	 * possibilities here. A safe choice to avoid the worst case is to use a
	 * random element from the array for a partitioning element. Then, the worst
	 * case will happen with negligibly small probability. This method is a
	 * simple example of a probabilistic algorithm—one that uses randomness to
	 * achieve good performance with high probability, regardless of the
	 * arrangement of the input.
	 * 
	 * @see QuickSorter
	 * 
	 * @author Nicolas Garnil
	 */

	public QuickMedianOfThreeSorter() {
		super(SorterType.QUICK_MED_OF_THREE);
	}

	/**
	 * 
	 * Sorts a list of given elements using QuickMedianOfThree Sort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the list to be sorted
	 * 
	 */

	@Override
	public <T> void sort(Comparator<T> comparator, List<T> list) {
		sort(comparator, list, 0, list.size() - 1, 7);
	}

	public <T> void sort(Comparator<T> comparator, List<T> list, int m) {
		sort(comparator, list, 0, list.size() - 1, m);
	}

	public <T> void sort(Comparator<T> comparator, List<T> list, int l, int r, int m) {
		if (r <= l)
			return;
		if (l + m > r) {
			insertionSort.sort(comparator, list, l, r + 1);
			return;
		}
		swap(list, (l + r) / 2, r - 1);
		if (greater(comparator, list, l, r - 1))
			swap(list, l, r - 1);
		if (greater(comparator, list, l, r))
			swap(list, l, r);
		if (greater(comparator, list, r - 1, r))
			swap(list, r - 1, r);
		int i = partition(comparator, list, l + 1, r - 1);
		sort(comparator, list, l, i - 1, m);
		sort(comparator, list, i + 1, r, m);
	}
}
