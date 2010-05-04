package anaydis.ngarnil.sort.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 
 * DataGenerator implementation. Use it to generate ascending, descending and random 
 * lists of Integers.
 * 
 * @author Nicolas Garnil
 *
 */

public class IntegerDataSetGenerator implements DataSetGenerator<Integer> {

	public List<Integer> createAscending(final int length) {
		final List<Integer> ascending = new ArrayList<Integer>();

		for (int i = 0; i < length; i++) {
			ascending.add(i, i);
		}

		return ascending;
	}

	public List<Integer> createDescending(final int length) {
		final List<Integer> descending = new ArrayList<Integer>();

		for (int i = 0; i < length; i++) {
			descending.add(i, length - i);
		}

		return descending;
	}

	public List<Integer> createRandom(final int length) {
		final List<Integer> random = new ArrayList<Integer>();

		final Random r = new Random();
		for (int i = 0; i < length; i++) {
			random.add(i, r.nextInt(length));
		}

		return random;
	}

	public List<Integer> createRepetitiveList(final int length) {
		final List<Integer> repetitiveList = new ArrayList<Integer>();
		final Random random = new Random();
		for (int i = 0; i < length; i++) {
			repetitiveList.add(i, random.nextInt(i+1));
		}
		return repetitiveList;
	}

	private static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};

	public Comparator<Integer> getComparator() {
		return INTEGER_COMPARATOR;
	}
}
