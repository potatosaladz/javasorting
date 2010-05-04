package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * When there are many duplicate keys present in the file to be sorted, the
 * quicksort implementations do not have unacceptably poor performance, but they
 * can be substantially improved. A clever method invented by Bentley and
 * McIlroy in 1993 for three-way partitioning works by modifying the standard
 * partitioning scheme as follows: Keep keys equal to the partitioning element
 * that are encountered in the left subfile at the left end of the file, and
 * keep keys equal to the partitioning element that are encountered in the right
 * subfile at the right end of the file.
 * 
 * @see QuickSorter
 * 
 * @author Nicolas Garnil
 */

public class QuickThreeWayPartitionSorter extends AbstractQuickSorter {

	public QuickThreeWayPartitionSorter() {
		super(SorterType.QUICK_THREE_PARTITION);
	}

	/**
	 * 
	 * Sorts a list of given elements using a non recursive
	 * QuickThreeWayPartition Sort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the list to be sorted
	 * 
	 */

	@Override
	public <T> void sort(Comparator<T> c, List<T> list) {
		sort(c, list, 0, list.size() - 1);
	}

	public <T> void sort(Comparator<T> comparator, List<T> list, int l, int r) {
		if (r <= l) {
			return;
		}
		int i = l - 1;
		int j = r;
		int p = l - 1;
		int q = r;
		int k;
		for (;;) {
			while (less(comparator, list, ++i, r))
				;
			while (less(comparator, list, r, --j)) {
				if (j == l) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			swap(list, i, j);

			if (equals(comparator, list, i, r)) {
				p++;
				swap(list, p, i);
			}
			if (equals(comparator, list, r, j)) {
				q--;
				swap(list, q, j);
			}
		}

		swap(list, i, r);

		j = i - 1;
		i = i + 1;
		for (k = l; k <= p; k++, j--) {
			swap(list, k, j);
		}
		for (k = r - 1; k >= q; k--, i++) {
			swap(list, k, i);
		}

		sort(comparator, list, l, j);
		sort(comparator, list, i, r);
	}
}
