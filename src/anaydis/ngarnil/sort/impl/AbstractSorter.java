package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.Sorter;
import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * Base class for all Sorters implementations. It is a MUST
 * to extend this class !
 * 
 * @author Nicolas Garnil
 * 
 */

public abstract class AbstractSorter implements Sorter {

	private SorterType type;

	protected AbstractSorter(SorterType type) {
		this.type = type;
	}

	@Override
	public abstract <T> void sort(Comparator<T> arg0, List<T> list);

	protected <T> boolean greater(Comparator<T> c, List<T> list, int i, int j) {
		return c.compare(list.get(i), list.get(j)) > 0;
	}

	protected <T> boolean less(Comparator<T> c, List<T> list, int i, int j) {
		return c.compare(list.get(i), list.get(j)) < 0;
	}

	protected <T> boolean equals(Comparator<T> c, List<T> list, int i, int j) {
		return c.compare(list.get(i), list.get(j)) == 0;
	}

	protected <T> void swap(List<T> list, int i, int j) {
		final T aux = list.get(i);
		list.set(i, list.get(j));
		list.set(j, aux);
	}

	protected <T> void copy(List<T> source, List<T> target, int from, int to, boolean copyToAux) {
		if(copyToAux) {
			target.add(source.get(from));
		} else {
			target.set(to, source.get(from));
		}
	}

	@Override
	public SorterType getType() {
		return type;
	}
	
}
