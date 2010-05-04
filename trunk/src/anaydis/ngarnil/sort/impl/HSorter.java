
package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * 
 * H-sorts a list. This implementation should be excluded from testing !
 * 
 * @author Nicolas Garnil
 *
 */

public class HSorter extends AbstractSorter {

	public HSorter() {
		this(SorterType.H);
	}

	protected HSorter(final SorterType type) {
		super(type);
	}

	public <T> void sort(Comparator<T> comparator, List<T> list) {
		sort(comparator, list, 4);
	}

	protected <T> void sort(Comparator<T> comparator, List<T> list, int h) {
		for (int i = h; i < list.size(); i++) {
			for (int j = i; j >= h && greater(comparator, list, j - h, j); j -= h) {
				swap(list, j - h, j);
			}
		}
	}
}
