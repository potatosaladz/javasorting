package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * A definite improvement to quicksort arises from the observation that a
 * recursive program is guaranteed to call itself for many small subfiles, so it
 * should use as good a method as possible when it encounters small subfiles.
 * One obvious way to arrange for it to do so is to change the test at the
 * beginning of the recursive routine from a return to a call on insertion sort.
 * 
 * @see QuickSorter
 * 
 * @author Nicolas Garnil
 * 
 */

public class QuickCutSorter extends AbstractQuickCutSorter {

	public QuickCutSorter() {
		super(SorterType.QUICK_CUT);
	}
	
	/**
	 * 
	 * Sorts a list of given elements using QuickCut Sort.
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
		sort(comparator, list, 0, list.size() - 1, 8);
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
		int i = partition(comparator, list, l, r);
		sort(comparator, list, l, i - 1, m);
		sort(comparator, list, i + 1, r, m);
	}
}
