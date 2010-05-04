package anaydis.ngarnil.sort.impl;

import java.util.Comparator;
import java.util.List;

import anaydis.ngarnil.sort.SorterType;

/**
 * The purpose of this class is to reuse the InsertionSorter which is 
 * present in all QuickSorts which cuts with InsertionSort. 
 * 
 * @author Nicolas Garnil
 * 
 */

public abstract class AbstractQuickCutSorter extends AbstractQuickSorter {

	protected InsertionSorter insertionSort;

	protected AbstractQuickCutSorter(SorterType type) {
		super(type);
		insertionSort = new InsertionSorter();
	}

	@Override
	public abstract <T> void sort(Comparator<T> comparator, List<T> list);

}
