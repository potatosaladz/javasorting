package anaydis.ngarnil.sort.impl;

import java.util.Comparator;

import anaydis.ngarnil.sort.impl.util.Node;

/**
 * 
 * Base class for LinkedList Merge Sort implementations.
 * 
 * @author Nicolas Garnil
 *
 */

public abstract class LinkedListMergeSorter extends LinkedListSorter {

	protected abstract <T> Node<T> sort(Comparator<T> comparator, Node<T> list);

	protected <T> Node<T> split(Node<T> list) {
		if (list.next == null) {
			return list;
		}
		Node<T> a = list;
		Node<T> b = list.next;
		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}
		Node<T> aux = a.next;
		a.next = null;
		return aux;
	}

	protected <T> Node<T> merge(Comparator<T> comparator, Node<T> a, Node<T> b) {
		Node<T> dummy = new Node<T>(null);
		Node<T> head = dummy, c = head;
		while ((a != null) && (b != null))
			if (less(comparator, a, b)) {
				c.next = a;
				c = a;
				a = a.next;
			} else {
				c.next = b;
				c = b;
				b = b.next;
			}
		c.next = (a == null) ? b : a;
		return head.next;
	}
}
