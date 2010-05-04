package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * Shellsort is a simple extension of insertion sort that gains speed by
 * allowing exchanges of elements that are far apart.
 * 
 * The idea is to rearrange the file to give it the property that taking every
 * hth element (starting anywhere) yields a sorted file. Such a file is said to
 * be h-sorted. Put another way, an h-sorted file is h independent sorted files,
 * interleaved together. By h-sorting for some large values of h, we can move
 * elements in the array long distances and thus make it easier to h-sort for
 * smaller values of h. Using such a procedure for any sequence of values of h
 * that ends in 1 will produce a sorted file: that is the essence of shellsort.
 * 
 * @see HSorter
 * 
 * @author Nicolas Garnil
 * 
 */

public class ShellSorter extends HSorter {

	public ShellSorter() {
		super(SorterType.SHELL);
	}

	/**
	 * 
	 * Sorts a list of given elements using Shell Sort.
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
		sort(comparator, list, 0, list.size() - 1);
	}

	private <T> void sort(Comparator<T> comparator, List<T> list, int l, int r) {
		int h;
		for (h = 1; h <= (r - l) / 9; h = 3 * h + 1)
			;
		for (; h > 0; h /= 3) {
			sort(comparator, list, h);
		}
	}

	public <T> void sort(Comparator<T> comparator, List<T> list, int[] secuence) {
		for (int h : secuence) {
			sort(comparator, list, h);
		}
	}
}
