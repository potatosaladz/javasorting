package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import anaydis.ngarnil.sort.SorterType;

/**
 * This nonrecursive implementation of quicksort uses an explicit pushdown
 * stack, replacing recursive calls with stack pushes (of the parameters) and
 * the procedure call/exit with a loop that pops parameters from the stack and
 * processes them as long as the stack is nonempty. We put the larger of the two
 * subfiles on the stack first to ensure that the maximum stack depth for
 * sorting N elements is lg N.
 * 
 * @see QuickSorter
 * 
 * @author Nicolas Garnil
 */

public class QuickNonRecursiveSorter extends AbstractQuickSorter {

	public QuickNonRecursiveSorter() {
		super(SorterType.QUICK_NON_RECURSIVE);
	}

	/**
	 * 
	 * Sorts a list of given elements using a non recursive Quick Sort.
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

	public <T> void sort(Comparator<T> comparator, List<T> list, int l, int r) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(l);
		stack.push(r);
		while (!stack.empty()) {
			r = stack.pop();
			l = stack.pop();
			if (r <= l) {
				continue;
			}
			int i = partition(comparator, list, l, r);
			if (i - l > r - i) {
				stack.push(l);
				stack.push(i - 1);
			}
			stack.push(i + 1);
			stack.push(r);
			if (r - i >= i - l) {
				stack.push(l);
				stack.push(i - 1);
			}
		}
	}
}
