package anaydis.ngarnil.sort.provider;

import java.util.EnumMap;
import java.util.Map;

import anaydis.ngarnil.sort.Sorter;
import anaydis.ngarnil.sort.SorterType;
import anaydis.ngarnil.sort.impl.BinaryHeapSorter;
import anaydis.ngarnil.sort.impl.BottomUpMergeSorter;
import anaydis.ngarnil.sort.impl.BubbleSorter;
import anaydis.ngarnil.sort.impl.HSorter;
import anaydis.ngarnil.sort.impl.InsertionSorter;
import anaydis.ngarnil.sort.impl.QuickCutSorter;
import anaydis.ngarnil.sort.impl.QuickMedianOfThreeSorter;
import anaydis.ngarnil.sort.impl.QuickNonRecursiveSorter;
import anaydis.ngarnil.sort.impl.QuickSorter;
import anaydis.ngarnil.sort.impl.QuickThreeWayPartitionSorter;
import anaydis.ngarnil.sort.impl.SelectionSorter;
import anaydis.ngarnil.sort.impl.ShellSorter;
import anaydis.ngarnil.sort.impl.TernaryHeapSorter;
import anaydis.ngarnil.sort.impl.TopDownMergeSorter;

/**
 * 
 * This class was created for testing purposes. It is not a must to use
 * a provider to get Sorter instances.
 * 
 * @author Nico
 *
 */

public class SorterProvider {

	private final Map<SorterType, Sorter> sorters;

	public SorterProvider() {
		sorters = new EnumMap<SorterType, Sorter>(SorterType.class);
		addSorters();
	}

	private void addSorters() {
		add(new BubbleSorter());
		add(new SelectionSorter());
		add(new InsertionSorter());
		add(new HSorter());
		add(new ShellSorter());
		add(new QuickSorter());
		add(new QuickCutSorter());
		add(new QuickNonRecursiveSorter());
		add(new QuickMedianOfThreeSorter());
		add(new BottomUpMergeSorter());
		add(new TopDownMergeSorter());
		add(new QuickThreeWayPartitionSorter());
		add(new BinaryHeapSorter());
		add(new TernaryHeapSorter());
	}

	private void add(Sorter sorter) {
		sorters.put(sorter.getType(), sorter);
	}

	public Iterable<Sorter> getAllSorters() {
		return sorters.values();
	}

	public Sorter getSorterForType(SorterType type) {
		return sorters.get(type);
	}
}
