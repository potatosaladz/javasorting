package anaydis.ngarnil.sort.impl;

import java.util.Comparator;

import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * <h1>Bubble Sort</h1>
 * 
 * One of the most basic sorting algorithms. Never use it !
 * 
 * Idea: Keep passing through the file, exchanging adjacent elements that are
 * out of order, continuing until the file is sorted. Bubble sort's prime virtue
 * is that it is easy to implement, but whether it is actually easier to
 * implement than insertion or selection sort is arguable.
 * 
 * @author Nicolas Garnil 
 * 
 **/

public class BubbleSorter extends AbstractSorter {

	public BubbleSorter() {
		super(SorterType.BUBBLE);
	}

	/**
	 * 
	 * Sorts a list of given elements using Bubble Sort algorithm.
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
		final int n = list.size();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (greater(comparator, list, j, j + 1)) {
					swap(list, j, j + 1);
				}
			}
		}
	}
}
