package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * Top-down mergesort is analogous to a top-down management style, where a
 * manager gets an organization to take on a big task by dividing it into pieces
 * to be solved independently by underlings. If each manager operates by simply
 * dividing the given task in half, then putting together the solutions that the
 * subordinates develop and passing the result up to a superior, the result is a
 * process like mergesort. Not much real work gets done until someone with no
 * subordinates gets a task (in this case, merging two files of size 1); but
 * management does much of the work, putting together solutions.
 *
 * @see AbstractMergeSorter
 * 
 * @author Nicolas Garnil
 * 
 */

public class TopDownMergeSorter extends AbstractMergeSorter {

	public TopDownMergeSorter() {
		super(SorterType.MERGE);
	}
	
	/**
	 * 
	 * Sorts a list of given elements using Top-Down Merge Sort.
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
		int m = (r + l) / 2;
		sort(comparator, list, l, m);
		sort(comparator, list, m + 1, r);
		merge(comparator, list, l, m, r);
	}
}
