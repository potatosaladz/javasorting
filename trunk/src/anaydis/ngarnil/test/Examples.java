package anaydis.ngarnil.test;

import java.util.Arrays;
import java.util.List;

import anaydis.ngarnil.sort.Sorter;
import anaydis.ngarnil.sort.SorterType;
import anaydis.ngarnil.sort.data.DataSetGenerator;
import anaydis.ngarnil.sort.data.IntegerDataSetGenerator;
import anaydis.ngarnil.sort.impl.ShellSorter;
import anaydis.ngarnil.sort.provider.SorterProvider;

public class Examples {
	
	public static void main(String[] args) {
		//GET an Integer DataGenerator instance
		DataSetGenerator<Integer> dataGenerator = new IntegerDataSetGenerator();
		//GET a SorterProvider instance
		SorterProvider sorterProvider = new SorterProvider();
		
		//CREATE a random list and sort it using QuickSort
		final List<Integer> randomList = dataGenerator.createRandom(1000);
		Sorter quickSort = sorterProvider.getSorterForType(SorterType.QUICK);
		quickSort.sort(dataGenerator.getComparator(), randomList);
		
		//CREATE a descending list and sort it using SelectionSort (Worst case !)
		final List<Integer> descendingList = dataGenerator.createDescending(1000);
		Sorter selectionSort = sorterProvider.getSorterForType(SorterType.QUICK);
		selectionSort.sort(dataGenerator.getComparator(), descendingList);
		
		String[] names = new String[]{"Mery", "Paul", "Bruce"};
		Sorter mergeSort = sorterProvider.getSorterForType(SorterType.MERGE);
		mergeSort.sort(new StringComparator(), Arrays.asList(names));
		
		String[] surnames = new String[]{"Smith", "Garnil", "Valentino"};
		Sorter shellSort = new ShellSorter();
		shellSort.sort(new StringComparator(),  Arrays.asList(surnames));
	}

}
