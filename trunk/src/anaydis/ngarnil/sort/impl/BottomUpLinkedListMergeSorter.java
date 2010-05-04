package anaydis.ngarnil.sort.impl;

import java.util.Comparator;

import anaydis.ngarnil.sort.impl.util.Node;
import anaydis.ngarnil.sort.impl.util.NodeQueue;

/**
 * 
 * LinkedList version of the Bottom-Up Merge Sort.
 * 
 * @see LinkedListMergeSorter
 * 
 * @author Nicolas Garnil
 * 
 */

public class BottomUpLinkedListMergeSorter extends LinkedListMergeSorter {

	/**
	 * Sorts a list of given elements using Bottom-Up linkedlist Sort.
	 * 
	 * Queue elements are ordered linked lists. After initializing the queue
	 * with lists of length 1, the program simply removes two lists from the
	 * queue, merges them, and puts the result back on the queue, continuing
	 * until there is only one list. This corresponds to a sequence of passes
	 * through all the elements, doubling the length of the ordered lists on
	 * each pass, as in bottom-up mergesort.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the first node of the linkedlist
	 */

	@Override
	protected <T> Node<T> sort(Comparator<T> comparator, Node<T> t) {
		NodeQueue<T> Q = new NodeQueue<T>();
		if (t == null || t.next == null) {
			return t;
		}
		for (Node<T> u = null; t != null; t = u) {
			u = t.next;
			t.next = null;
			Q.put(t);
		}
		t = Q.get();
		while (!Q.empty()) {
			Q.put(t);
			t = merge(comparator, Q.get(), Q.get());
		}
		return t;
	}
}
