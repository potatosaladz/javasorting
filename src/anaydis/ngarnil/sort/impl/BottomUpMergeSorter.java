package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * Bottom-up mergesort consists of a sequence of passes over the whole file
 * doing m-by-m merges, doubling m on each pass. The final subfile is of size m
 * only if the file size is an even multiple of m, so the final merge is an
 * m-by-x merge, for some x less than or equal to m.
 * 
 * @see AbstractMergeSorter
 * 
 * @author Nicolas Garnil
 */

public class BottomUpMergeSorter extends AbstractMergeSorter {

	public BottomUpMergeSorter() {
		super(SorterType.MERGE_BOTTOM_UP);
	}

	/**
	 * 
	 * Sorts a list of given elements using Bottom-Up Mergege Sort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the list to be sorted
	 */

	@Override
	public <T> void sort(Comparator<T> comparator, List<T> list) {
		sort(comparator, list, 0, list.size() - 1);
	}

	public <T> void sort(Comparator<T> comparator, List<T> list, int l, int r) {
		if (r <= l) {
			return;
		}
		for (int m = 1; m <= r - l; m = 2 * m) {
			for (int i = l; i <= r - m; i += 2 * m) {
				merge(comparator, list, i, i + m - 1, Math.min(i + m + m - 1, r));
			}
		}
	}
}
