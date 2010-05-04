package anaydis.ngarnil.sort.impl;

import java.util.Comparator;

import anaydis.ngarnil.sort.impl.util.Node;

public abstract class LinkedListSorter {

	protected <T> boolean less(Comparator<T> comparator, Node<T> a, Node<T> b) {
		return comparator.compare(a.value, b.value) < 0;
	}

}
