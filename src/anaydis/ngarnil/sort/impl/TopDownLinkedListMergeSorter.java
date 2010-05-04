package anaydis.ngarnil.sort.impl;

import java.util.Comparator;

import anaydis.ngarnil.sort.impl.util.Node;

/**
 * 
 * One important feature of this method is that it method takes advantage of any
 * order that might be already present in the file. Indeed, the number of passes
 * through the list is not lg N , but rather is lg S , where S is the number of
 * ordered subfiles in the original array. Mergesorts with this property are
 * sometimes called natural mergesorts. For random files, natural mergesorts
 * offer no great advantage, because only a pass or two is likely to be saved
 * (in fact, the method is likely to be slower than the top-down method, because
 * of the extra cost of checking for order in the file), but it is not uncommon
 * for a file to consist of blocks of ordered subfiles, and this method will be
 * effective in such situations.
 * 
 * @see LinkedListMergeSorter
 * 
 * @author Nicolas Garnil
 * 
 */

public class TopDownLinkedListMergeSorter extends LinkedListMergeSorter {

	/**
	 * Sorts by splitting the list referenced by c into two halves referenced by
	 * a and b, sorting the two halves recursively, and then using merge to
	 * produce the final result.
	 * 
	 * @param comparator
	 *            a java.util.Comparator
	 * 
	 * @param list
	 *            the first node of the linkedlist
	 */

	@Override
	public <T> Node<T> sort(Comparator<T> comparator, Node<T> list) {
		Node<T> secondHalf = split(list);
		if (secondHalf == list) {
			return list;
		}
		Node<T> a = sort(comparator, list);
		Node<T> b = sort(comparator, secondHalf);
		return merge(comparator, a, b);
	}

}
