package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * Quicksort is a divide-and-conquer method for sorting. It works by
 * partitioning an array into two parts, then sorting the parts independently.
 * As we shall see, the precise position of the partition depends on the initial
 * order of the elements in the input file. The crux of the method is the
 * partitioning process, which rearranges the array to make the following three
 * conditions hold
 * 
 * @see QuickSorter
 * 
 * @author Nicolas Garnil
 */

public class QuickSorter extends AbstractQuickSorter {

	public QuickSorter() {
		super(SorterType.QUICK);
	}

	/**
	 * 
	 * Sorts a list of given elements using Quick Sort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the list to be sorted
	 * 
	 */

	public <T> void sort(Comparator<T> comparator, List<T> list) {
		quickSort(comparator, list, 0, list.size() - 1);
	}

	public <T> void quickSort(Comparator<T> comparator, List<T> list, int l, int r) {
		if (r <= l) {
			return;
		}
		int i = partition(comparator, list, l, r);
		quickSort(comparator, list, l, i - 1);
		quickSort(comparator, list, i + 1, r);
	}
}