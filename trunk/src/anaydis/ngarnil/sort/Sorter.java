package anaydis.ngarnil.sort;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.impl.AbstractSorter;

/**
 * 
 * Base interface for all sorters implementations. Do not use ! Instead extend
 * AbstractSorter.
 * 
 * @see AbstractSorter
 * 
 * @author Nicolas Garnil
 * 
 */
public interface Sorter {

	<T> void sort(Comparator<T> comparator, List<T> list);

	SorterType getType();
}
